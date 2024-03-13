import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppModule } from './app/app.module';
import axios from 'axios';

axios.interceptors.request.use(function (config) {
  config.headers.Authorization = `Bearer ${localStorage.getItem('sesion')}`;
  // Haz algo antes que la petición se ha enviada
  return config;
}, function (error) {
  // Haz algo con el error de la petición
  return Promise.reject(error);
});

platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
