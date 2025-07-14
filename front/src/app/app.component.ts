import {HttpClient} from '@angular/common/http';
import {Component} from '@angular/core';

interface TranslateResponse {
  spanish: string;
  english: string;
}

interface TranslateRequest {
  text: string;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  
  pt: string = '';
  es: string = '';
  en: string = '';
  isLoading: boolean = false;

  constructor(private http: HttpClient) {}

  translate(): void {
    if (!this.pt) {
      alert('Por favor, preencha o texto em português');
      return;
    }

    this.isLoading = true;
    
    const requestData: TranslateRequest = {
      text: this.pt
    };

    this.http.post<TranslateResponse>('http://localhost:8080/api/translate', requestData)
      .subscribe({
        next: (response: TranslateResponse) => {
          this.es = response.spanish;
          this.en = response.english;
          this.isLoading = false;
        },
        error: (error) => {
          console.error('Erro na tradução:', error);
          alert('Erro ao traduzir. Verifique se o backend está rodando.');
          this.isLoading = false;
        }
      });
  }

  clear(): void {
    this.pt = '';
    this.es = '';
    this.en = '';
  }
}