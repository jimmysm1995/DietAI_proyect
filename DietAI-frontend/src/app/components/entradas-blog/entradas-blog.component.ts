import { Component } from '@angular/core';

@Component({
  selector: 'app-entradas-blog',
  templateUrl: './entradas-blog.component.html',
  styleUrls: ['./entradas-blog.component.css']
})
export class EntradasBlogComponent {
  blogs: any[] = [
    { 
      title: 'Alimentación Saludable y Nutritiva para tu Salud y Bienestar', 
      image: '../../assets/IMG/blog1.jpg', 
      description: 'Descubre los beneficios de una alimentación equilibrada y nutritiva. En este blog, encontrarás consejos prácticos para mejorar tus hábitos alimenticios y alcanzar tus objetivos de salud.' 
    },
    { 
      title: 'Los 10 Mejores Alimentos para Potenciar tu Entrenamiento', 
      image: '../../assets/IMG/blog2.jpg', 
      description: 'Descubre cuáles son los alimentos ideales para maximizar tu rendimiento durante el entrenamiento. Conoce los nutrientes esenciales que necesitas para obtener los mejores resultados en tus sesiones de ejercicio.' 
    },
    { 
      title: 'Ejercicios en Casa: Rutinas Efectivas para Mantenerte Activo', 
      image: '../../assets/IMG/blog3.jpg', 
      description: 'Descubre cómo puedes mantenerte activo y en forma desde la comodidad de tu hogar. En este blog, te mostramos rutinas de ejercicio efectivas que puedes hacer sin necesidad de ir al gimnasio.' 
    },
  ];

}
