// blog.component.ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.css']
})
export class BlogComponent {
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
    { 
      title: 'Cómo Reducir el Estrés a Través de la Alimentación y el Ejercicio', 
      image: '../../assets/IMG/blog4.jpg', 
      description: 'Aprende cómo puedes manejar el estrés mediante una combinación de alimentación saludable y actividad física. Descubre técnicas y consejos para mantener un equilibrio mental y emocional en tu vida diaria.' 
    },
    { 
      title: 'Desayunos Energéticos: Ideas Rápidas y Nutritivas para Comenzar el Día', 
      image: '../../assets/IMG/blog.jpg', 
      description: 'Empieza el día con energía con estos deliciosos desayunos nutritivos. Encuentra recetas rápidas y fáciles que te ayudarán a recargar tus baterías y mantener un alto nivel de energía durante toda la mañana.' 
    },
    { 
      title: 'Entrenamiento de Intervalos de Alta Intensidad (HIIT): Quema Grasa y Mejora tu Condición Física', 
      image: '../../assets/IMG/blog5.jpg', 
      description: 'Descubre los beneficios del entrenamiento HIIT para tu salud y condición física. Aprende cómo este tipo de ejercicio puede ayudarte a quemar grasa, mejorar tu resistencia y aumentar tu metabolismo.' 
    },
    { 
      title: 'Alimentación Saludable y Nutritiva para tu salud', 
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
    { 
      title: 'Cómo Reducir el Estrés a Través de la Alimentación y el Ejercicio', 
      image: '../../assets/IMG/blog4.jpg', 
      description: 'Aprende cómo puedes manejar el estrés mediante una combinación de alimentación saludable y actividad física. Descubre técnicas y consejos para mantener un equilibrio mental y emocional en tu vida diaria.' 
    },
    { 
      title: 'Desayunos Energéticos: Ideas Rápidas y Nutritivas para Comenzar el Día', 
      image: '../../assets/IMG/blog.jpg', 
      description: 'Empieza el día con energía con estos deliciosos desayunos nutritivos. Encuentra recetas rápidas y fáciles que te ayudarán a recargar tus baterías y mantener un alto nivel de energía durante toda la mañana.' 
    },
    { 
      title: 'Entrenamiento de Intervalos de Alta Intensidad (HIIT): Quema Grasa y Mejora tu Condición Física', 
      image: '../../assets/IMG/blog5.jpg', 
      description: 'Descubre los beneficios del entrenamiento HIIT para tu salud y condición física. Aprende cómo este tipo de ejercicio puede ayudarte a quemar grasa, mejorar tu resistencia y aumentar tu metabolismo.' 
    },

  ];
}
