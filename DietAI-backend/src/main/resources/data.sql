-- Insertar datos en la tabla Muscle
INSERT INTO Muscle (name) VALUES
('Pecho'),
('Espalda'),
('Bíceps'),
('Tríceps'),
('Hombros'),
('Piernas'),
('Gluteos'),
('Femoral'),
('Abdominales'),
('Oblicuos');

INSERT INTO Imagen_profile (url) VALUES
('https://st2.depositphotos.com/1036149/5790/i/600/depositphotos_57900109-stock-photo-fun-frog-in-suit-with.jpg'),
('https://st2.depositphotos.com/1036149/6187/i/450/depositphotos_61871905-stock-photo-strong-frog-3d.jpg'),
('https://st.depositphotos.com/1036149/3669/i/600/depositphotos_36692137-stock-photo-strong-frog.jpg'),
('https://st2.depositphotos.com/1036149/5790/i/600/depositphotos_57900109-stock-photo-fun-frog-in-suit-with.jpg'),
('https://st2.depositphotos.com/1036149/6187/i/450/depositphotos_61871905-stock-photo-strong-frog-3d.jpg'),
('https://st.depositphotos.com/1036149/3669/i/600/depositphotos_36692137-stock-photo-strong-frog.jpg');


INSERT INTO Home_exercise (name, difficult, explanation)
VALUES
('Flexiones', 3, 'Ejercicio básico para entrenar el pecho y los tríceps.'),
('Sentadillas', 2, 'Ejercicio para fortalecer las piernas y glúteos.'),
('Plancha', 3, 'Ejercicio para fortalecer el core y los hombros.'),
('Zancadas', 2, 'Ejercicio para piernas y glúteos.'),
('Abdominales', 2, 'Ejercicio para fortalecer los abdominales.'),
('Burpees', 4, 'Ejercicio completo que involucra pecho, piernas, tríceps y abdomen.'),
('Mountain climbers', 3, 'Ejercicio cardiovascular que trabaja piernas, abdominales y brazos.'),
('Plancha lateral', 3, 'Ejercicio que fortalece oblicuos y abdomen.'),
('Flexiones diamante', 3, 'Variante de flexiones para trabajar tríceps.'),
('Sentadilla sumo', 2, 'Variante de sentadilla que enfoca en glúteos e interior de muslos.');



INSERT INTO Home_exercise_muscle (id_home_exercise, id_muscle)
VALUES
(1, 1), -- Flexiones - Pecho
(1, 4), -- Flexiones - Tríceps
(2, 6), -- Sentadillas - Piernas
(2, 7), -- Sentadillas - Glúteos
(3, 9), -- Plancha - Abdominales
(3, 5), -- Plancha - Hombros
(4, 6), -- Zancadas - Piernas
(4, 7), -- Zancadas - Glúteos
(5, 9), -- Abdominales - Abdominales
(6, 1), -- Burpees - Pecho
(6, 6), -- Burpees - Piernas
(6, 4), -- Burpees - Tríceps
(6, 9), -- Burpees - Abdominales
(7, 6), -- Mountain climbers - Piernas
(7, 9), -- Mountain climbers - Abdominales
(7, 5), -- Mountain climbers - Brazos
(8, 9), -- Plancha lateral - Abdominales
(8, 10), -- pancha lateral - Oblicuos
(9, 4), -- Flexiones diamante - Tríceps
(9, 7), -- Sentadilla sumo - Glúteos
(9, 4); -- Sentadilla sumo - Piernas

INSERT INTO Gym_Exercise (name, difficult, explanation)
VALUES
('Press de pecho en máquina', 3, 'Ejercicio para desarrollar el pectoral mayor.'),
('Prensa de piernas', 3, 'Ejercicio para fortalecer los cuádriceps y glúteos.'),
('Peso muerto con barra', 4, 'Ejercicio compuesto para trabajar la espalda baja, piernas y glúteos.'),
('Remo con barra', 3, 'Ejercicio para fortalecer la espalda y bíceps.'),
('Press militar con mancuernas', 3, 'Ejercicio para desarrollar los hombros y tríceps.'),
('Sentadillas con barra', 4, 'Ejercicio compuesto para trabajar piernas y glúteos.'),
('Leg press', 3, 'Ejercicio para trabajar los cuádriceps, glúteos y músculos de la parte inferior del cuerpo.'),
('Pull-up', 4, 'Ejercicio para fortalecer la espalda, bíceps y hombros.'),
('Pulldown en máquina', 3, 'Ejercicio para trabajar los músculos de la espalda, especialmente el dorsal ancho.'),
('Curl de bíceps con barra', 3, 'Ejercicio para aislar y fortalecer los músculos del bíceps.'),
('Extensiones de tríceps en polea alta', 3, 'Ejercicio para fortalecer los músculos del tríceps.'),
('Prensa de hombros con mancuernas', 3, 'Ejercicio para desarrollar los músculos del hombro y tríceps.');



-- Press de banca: Pecho
-- Peso muerto: Espalda, Piernas
INSERT INTO Gym_Exercise_Muscle (id_Gym_Exercise, id_Muscle)
VALUES
(1, 1), -- Press de pecho en máquina - Pecho
(2, 6), -- Prensa de piernas - Piernas
(2, 7), -- Prensa de piernas - Glúteos
(3, 8), -- Peso muerto con barra - Espalda baja
(3, 6), -- Peso muerto con barra - Piernas
(3, 7), -- Peso muerto con barra - Glúteos
(4, 2), -- Remo con barra - Espalda
(4, 3), -- Remo con barra - Bíceps
(5, 5), -- Press militar con mancuernas - Hombros
(5, 4), -- Press militar con mancuernas - Tríceps
(6, 6), -- Sentadillas con barra - Piernas
(6, 7), -- Sentadillas con barra - Glúteos
(7, 6), -- Leg press - Piernas
(7, 7), -- Leg press - Glúteos
(8, 2), -- Pull-up - Espalda
(8, 3), -- Pull-up - Bíceps
(8, 5), -- Pull-up - Hombros
(9, 2), -- Pulldown en máquina - Espalda
(10, 3), -- Curl de bíceps con barra - Bíceps
(11, 4), -- Extensiones de tríceps en polea alta - Tríceps
(12, 5), -- Prensa de hombros con mancuernas - Hombros
(12, 4); -- Prensa de hombros con mancuernas - Tríceps

INSERT INTO training (name, type_training, difficulty, days, distribution)
VALUES ('Entrenamiento prueba', 'GYM', 6, 3, 'Full body');

-- Insertar datos en la tabla TrainingExercise
INSERT INTO Training_exercise (sets, repetitions, day_week, id_training, id_Gym_Exercise, id_home_exercise)
VALUES
(3, 10,'MONDAY', 1, 1, null),
(3, 10,'MONDAY', 1, 2, null),
(3, 10,'MONDAY', 1, 3, null),
(3, 10,'WEDNESDAY', 1, 1, null),
(3, 10,'WEDNESDAY', 1, 2, null),
(3, 10,'WEDNESDAY', 1, 3, null),
(3, 10,'Friday', 1, 1, null),
(3, 10,'Friday', 1, 2, null),
(3, 10,'Friday', 1, 3, null);


-- Insertar datos en la tabla ingredient
INSERT INTO ingredient (name, protein, carbohydrates, fats)
VALUES
  ("arroz", 2.7, 77.5, 0.9),
  ("pollo", 20.6, 0, 4.5),
  ("leche", 3.4, 4.8, 3.6),
  ("aceite de oliva", 0, 0, 100),
  ("huevo", 13, 1.1, 11),
  ("avena", 16.9, 66.3, 6.9),
  ("yogur", 3.5, 4.7, 3.3),
  ("manzana", 0.3, 14, 0.4),
  ("plátano", 1.3, 27, 0.4),
  ("pan integral", 8.5, 49.7, 2.4),
  ("zanahoria", 0.9, 6.8, 0.2),
  ("queso cheddar", 24.9, 1.3, 33.1),
  ("pasta", 5.8, 77, 1.3),
  ("atún enlatado", 26, 0, 9),
  ("espinacas", 2.9, 3.6, 0.4),
  ("plátano macho", 1.3, 31.2, 0.2),
  ("calabacín", 1.2, 3.1, 0.3),
  ("garbanzos", 8.9, 27.4, 2.8),
  ("nuez", 15.2, 6.9, 68.5),
  ("piña", 0.5, 11.8, 0.2),
  ("papa", 2, 17, 0.1),
  ("hummus", 8, 14, 26),
  ("aguacate", 2, 9, 15),
  ("brócoli", 2.8, 7, 0.4);




