import {HttpClient} from '@angular/common/http';
import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  keyValue: string = '';
  pt: string = '';
  es: string = '';
  en: string = '';
  isLoading: boolean = false;

  constructor(private http: HttpClient) {
  }

  translate() {
    if (!this.keyValue || !this.pt) {
      alert('Por favor, preencha a chave e o texto em português');
      return;
    }

    this.isLoading = true;

    const requestData = {
      key: this.keyValue,
      text: this.pt
    };

    this.http.post<any>('http://localhost:8080/api/translate', requestData)
      .subscribe({
        next: (response: any) => {
          this.es = response.spanish;
          this.en = response.english;
          this.isLoading = false;
        },
        error: (error: any) => {
          console.error('Erro na tradução:', error);
          this.isLoading = false;
        }
      });
  }

  clear() {
    this.keyValue = '';
    this.pt = '';
    this.es = '';
    this.en = '';
  }
}
