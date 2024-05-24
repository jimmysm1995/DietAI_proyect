-- Insertar datos en la tabla Muscle
INSERT INTO muscle (name) VALUES
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

-- Insertar datos en la tabla Allergy
INSERT INTO allergy (name)
VALUES
('Cacahuetes'),
('Frutos secos'),
('Mariscos'),
('Pescado'),
('Leche'),
('Huevo'),
('Trigo'),
('Soja'),
('Sésamo'),
('Sulfitos');

-- Insertar datos en la tabla Quotes
INSERT INTO quotes (name)
VALUES
('El éxito no es definitivo, el fracaso no es fatal: es el coraje para continuar lo que cuenta.'),
('Cada día es una nueva oportunidad para cambiar tu vida.'),
('Las montañas más altas surgen de las grietas más profundas.'),
('Nunca subestimes el poder de tus sueños y la influencia positiva que pueden tener en el mundo.'),
('El optimismo es la fe que conduce al logro. Nada puede hacerse sin esperanza y confianza.'),
('No importa cuántas veces caigas, lo importante es levantarse una vez más.'),
('La única forma de hacer un gran trabajo es amar lo que haces.'),
('Cree en ti mismo y en todo lo que eres. Sabes que hay algo dentro de ti que es más grande que cualquier obstáculo.'),
('La diferencia entre lo imposible y lo posible está en la determinación de una persona.');


INSERT INTO injury (name)
VALUES
('Esguince de tobillo'),
('Codo de tenista'),
('Rodilla del corredor'),
('Lesión del manguito rotador'),
('Codo de golfista'),
('Distensión del tendón de la corva'),
('Síndrome de la cintilla iliotibial'),
('Tendinitis del tendón de Aquiles'),
('Conmoción cerebral'),
('Tirón en la ingle');


-- Insertar datos en la tabla Imagen_profile
INSERT INTO imagen_profile (url)
VALUES
('https://st2.depositphotos.com/1036149/5790/i/600/depositphotos_57900109-stock-photo-fun-frog-in-suit-with.jpg'),
('https://st2.depositphotos.com/1036149/6187/i/450/depositphotos_61871905-stock-photo-strong-frog-3d.jpg'),
('https://st.depositphotos.com/1036149/3669/i/600/depositphotos_36692137-stock-photo-strong-frog.jpg'),
('https://st3.depositphotos.com/1036149/18676/i/600/depositphotos_186769398-stock-photo-fun-frog-weights-illustration.jpg'),
('https://st3.depositphotos.com/1036149/17257/i/600/depositphotos_172576090-stock-photo-fun-frog-illustration.jpg'),
('https://st2.depositphotos.com/1036149/6187/i/600/depositphotos_61871765-stock-photo-strong-frog-3d.jpg');

-- Insertar datos en la tabla Home_exercise_muscle
--INSERT INTO Home_exercise_muscle (id_home_exercise, id_muscle)
--VALUES
--(1, 1), -- Flexiones - Pecho
--(1, 4), -- Flexiones - Tríceps
--(2, 6), -- Sentadillas - Piernas
--(2, 7), -- Sentadillas - Glúteos
--(3, 9), -- Plancha - Abdominales
--(3, 5), -- Plancha - Hombros
--(4, 6), -- Zancadas - Piernas
--(4, 7), -- Zancadas - Glúteos
--(5, 9), -- Abdominales - Abdominales
--(6, 1), -- Burpees - Pecho
--(6, 6), -- Burpees - Piernas
--(6, 4), -- Burpees - Tríceps
--(6, 9), -- Burpees - Abdominales
--(7, 6), -- Mountain climbers - Piernas
--(7, 9), -- Mountain climbers - Abdominales
--(7, 5), -- Mountain climbers - Brazos
--(8, 9), -- Plancha lateral - Abdominales
--(8, 10), -- pancha lateral - Oblicuos
--(9, 4), -- Flexiones diamante - Tríceps
--(9, 7), -- Sentadilla sumo - Glúteos
--(9, 4); -- Sentadilla sumo - Piernas


-- Insertar datos en la tabla Gym_exercise
INSERT INTO exercise (name,img_exercise,initial_position,execution,advices,type_training)
VALUES
('Press de pecho en barra',
    'https://www.entrenamientos.com/media/cache/exercise_375/uploads/exercise/press-de-banca-con-barra-init-pos-3832.png',
    'Seleccione la cantidad de discos apropiada para ponerlos en la barra. Túmbese boca arriba en un banco plano, sus ojos deben estar debajo de la barra. Sus pies deben tocar el suelo.',
    'Descienda suavemente la barra hacia el pecho mientras inhala Después de 1 seg., empuje la barra de vuelta a la posición de inicio mientras exhala. Repita el movimiento hasta que comprete las repeticiones .',
    'Centrese en empujar la barra con los musculos del pecho y apriete los gluteos cuando lo haga Si usted es un principiante, utilice un ayudante. So no hay ninguno, sea conservador con la carga que utiliza.',
    'GIMNASIO'),
('Prensa de piernas',
    'https://www.entrenamientos.com/media/cache/exercise_375/uploads/exercise/prensa-de-piernas-inclinada-init-pos-4016.png',
    'Seleccione la cantidad de discos apropiada para ponerlos en la máquina. Siéntese en la máquina y coloque los pies en la plataforma, separados al ancho de los hombros. Agarre las asas laterales de la máquina.',
    'Baje la plataforma con un movimiento suave hasta que sus rodillas formen un ángulo de 90 grados mientras inhala. Aguante 1 seg. Empuje la plataforma desde los talones de sus pies y vuelva a la posición inicial mientras exhala.',
    'Compruebe siempre si ha bloqueado correctamente la máquina después de repeticiones. Si usted es un principiante sea conservador con la carga que utiliza.',
    'GIMNASIO'),
('Peso muerto con barra',
    'https://www.entrenamientos.com/media/cache/exercise_375/uploads/exercise/peso-muerto-rumano-o-con-piernas-estiradas-init-pos-6354.png',
    'Sostenga una barra al nivel de la cadera con un agarre prono y con las manos al ancho de los hombros. Separe los pies al ancho de las caderas. Retraiga sus omoplatos. Contraiga el suelo pelvico y el core mientras mantiene su pecho levantado.',
    'Baje la barra moviendo su trasero hacia atrás hasta donde pueda mantener la barra cerca de sus piernas. Asegúrese de no mover la espalda y de hacer el ejercicio con las caderas.',
    'Centrese en apretar la columna todo el tiempo usando sus musculos del core.',
    'GIMNASIO'),
('Remo con barra',
    'https://www.entrenamientos.com/media/cache/exercise_375/uploads/exercise/remo-con-barra-de-pie-init-pos-6237.png',
     'Sostenga una barra al nivel de la cadera con un agarre prono y con las manos al ancho de los hombros. Separe los pies al ancho de las caderas. Retraiga sus omoplatos. Manteniendo el arco natural de su espalda.',
     'Tire de la barra hacia su torso retrayendo las escápulas mientras exhala hasta que toque los abdominales. Vuelva a la posición inicial con un suave movimiento.',
     'Mientras hace el ejercicio, mueva solo los brazos, asegúrese de no mover ninguna otra parte de su cuerpo. La clave del ejercicio es la calidad sobre la cantidad. El truco es realizar el ejercicio con la forma adecuada.',
     'GIMNASIO'),
('Press militar con mancuernas',
    'https://www.entrenamientos.com/media/cache/exercise_375/uploads/exercise/press-militar-o-de-hombros-con-mancuernas-de-pie-init-pos-1697.png',
    'Coja las mancuernas a los lados de los hombros mientras mantiene los codos doblados y en línea con su torso. Las manos deben estar ligeramente más separadas que el ancho de los hombros.',
    'Extienda los brazos para empujar las mancuernas hacia arriba hasta que los codos estén extendidos pero no bloqueados. Baje lentamente el peso hasta que sus manos estén justo por encima de los hombros.',
    'Modifique su agarre (neutral, ancho, angosto e inverso) de vez en cuando para entrenar los músculos desde múltiples ángulos. La clave del ejercicio es la calidad sobre la cantidad. El truco es realizar el ejercicio con la forma adecuada.',
    'GIMNASIO'
    );
--('Sentadillas con barra', 4, 'Ejercicio compuesto para trabajar piernas y glúteos.'),
--('Leg press', 3, 'Ejercicio para trabajar los cuádriceps, glúteos y músculos de la parte inferior del cuerpo.'),
--('Pull-up', 4, 'Ejercicio para fortalecer la espalda, bíceps y hombros.'),
--('Pulldown en máquina', 3, 'Ejercicio para trabajar los músculos de la espalda, especialmente el dorsal ancho.'),
--('Curl de bíceps con barra', 3, 'Ejercicio para aislar y fortalecer los músculos del bíceps.'),
--('Extensiones de tríceps en polea alta', 3, 'Ejercicio para fortalecer los músculos del tríceps.'),
--('Prensa de hombros con mancuernas', 3, 'Ejercicio para desarrollar los músculos del hombro y tríceps.'),
--('Flexiones', 3, 'Ejercicio básico para entrenar el pecho y los tríceps.'),
--('Sentadillas', 2, 'Ejercicio para fortalecer las piernas y glúteos.'),
--('Plancha', 3, 'Ejercicio para fortalecer el core y los hombros.'),
--('Zancadas', 2, 'Ejercicio para piernas y glúteos.'),
--('Abdominales', 2, 'Ejercicio para fortalecer los abdominales.'),
--('Burpees', 4, 'Ejercicio completo que involucra pecho, piernas, tríceps y abdomen.'),
--('Mountain climbers', 3, 'Ejercicio cardiovascular que trabaja piernas, abdominales y brazos.'),
--('Plancha lateral', 3, 'Ejercicio que fortalece oblicuos y abdomen.'),
--('Flexiones diamante', 3, 'Variante de flexiones para trabajar tríceps.'),
--('Sentadilla sumo', 2, 'Variante de sentadilla que enfoca en glúteos e interior de muslos.');

-- Insertar datos en la tabla Gym_Exercise_Muscle
INSERT INTO exercise_muscle (id_exercise, id_muscle)
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
(5, 4); -- Press militar con mancuernas - Tríceps
--(6, 6), -- Sentadillas con barra - Piernas
--(6, 7), -- Sentadillas con barra - Glúteos
--(7, 6), -- Leg press - Piernas
--(7, 7), -- Leg press - Glúteos
--(8, 2), -- Pull-up - Espalda
--(8, 3), -- Pull-up - Bíceps
--(8, 5), -- Pull-up - Hombros
--(9, 2), -- Pulldown en máquina - Espalda
--(10, 3), -- Curl de bíceps con barra - Bíceps
--(11, 4), -- Extensiones de tríceps en polea alta - Tríceps
--(12, 5), -- Prensa de hombros con mancuernas - Hombros
--(12, 4), -- Prensa de hombros con mancuernas - Tríceps
--(13, 1), -- Flexiones - Pecho
--(13, 4), -- Flexiones - Tríceps
--(14, 6), -- Sentadillas - Piernas
--(14, 7), -- Sentadillas - Glúteos
--(15, 9), -- Plancha - Abdominales
--(15, 5), -- Plancha - Hombros
--(16, 6), -- Zancadas - Piernas
--(16, 7), -- Zancadas - Glúteos
--(17, 9), -- Abdominales - Abdominales
--(18, 1), -- Burpees - Pecho
--(18, 6), -- Burpees - Piernas
--(18, 4), -- Burpees - Tríceps
--(18, 9), -- Burpees - Abdominales
--(19, 6), -- Mountain climbers - Piernas
--(19, 9), -- Mountain climbers - Abdominales
--(19, 5), -- Mountain climbers - Brazos
--(20, 9), -- Plancha lateral - Abdominales
--(20, 10), -- pancha lateral - Oblicuos
--(21, 4), -- Flexiones diamante - Tríceps
--(22, 7), -- Sentadilla sumo - Glúteos
--(22, 4); -- Sentadilla sumo - Piernas

-- Insertar datos en la tabla training
INSERT INTO training (name, type_training, difficulty, days, distribution)
VALUES ('Entrenamiento prueba', 'GIMNASIO', 3, 3, 'Full body');

-- Insertar datos en la tabla TrainingExercise
INSERT INTO training_exercise (sets, reps, order_day, order_week, id_training, id_exercise)
VALUES
(3, 10,1,1, 1, 1),
(3, 10,2,1, 1, 2),
(3, 10,3,1, 1, 3),
(3, 10,1,2, 1, 1),
(3, 10,2,2, 1, 2),
(3, 10,3,2, 1, 3),
(3, 10,1,3, 1, 1),
(3, 10,2,3, 1, 2),
(3, 10,3,3, 1, 3);


-- Insertar datos en la tabla de ingredientes
INSERT INTO ingredient (name, protein, carbohydrates, fats, calories)
VALUES ('Pollo', 25.0, 0.0, 3.0, 120), -- 1
        ('Pasta', 10.0, 20.0, 5.0, 380),
        ('Arroz', 2.7, 28.0, 0.3, 130),
        ('Brócoli', 2.8, 6.6, 0.4, 34),
        ('Pechuga de pavo', 17.0, 1.0, 1.0, 90),
        ('Zanahoria', 0.9, 9.6, 0.2, 41),
        ('Salmón', 20.4, 0.0, 13.6, 208),
        ('Pan de molde', 8.0, 50.0, 2.0, 265),
        ('Tomate', 0.9, 3.9, 0.2, 18),
        ('Cebolla', 1.1, 9.3, 0.1, 40), --10
        ('Aceite de oliva', 0.0, 0.0, 100.0, 884),
        ('Espinacas', 2.9, 3.6, 0.4, 23),
        ('Pavo', 29.0, 0.0, 1.0, 135),
        ('Patata', 2.0, 17.5, 0.1, 77),
        ('Queso', 25.0, 1.3, 33.0, 402),
        ('Atún en lata', 26.0, 0.0, 10.0, 180),
        ('Huevo', 13.0, 1.1, 11.0, 155),
        ('Lechuga', 1.4, 2.9, 0.2, 15),
        ('Aguacate', 2.0, 9.0, 15.0, 160),
        ('Yogur griego', 10.0, 3.6, 5.0, 120), --20
        ('Garbanzos cocidos', 8.9, 27.4, 2.6, 164),
        ('Filete de ternera', 21.4, 0.0, 3.0, 117),
        ('Manzana', 0.3, 14.0, 0.2, 52),
        ('Nuez', 15.0, 7.0, 65.0, 654),
        ('Avena', 13.0, 66.0, 7.0, 389),
        ('Sardinas en lata', 20.5, 0.0, 10.6, 180),
        ('Mango', 0.8, 14.0, 0.4, 60),
        ('Camarones', 24.0, 0.0, 1.0, 110),
        ('Filete de pavo', 24.0, 0.0, 1.5, 130),
        ('Pimiento rojo', 1.0, 4.2, 0.3, 20), --30
        ('Acelgas', 2.9, 3.7, 0.4, 19),
        ('Frambuesas', 1.5, 12.0, 0.7, 52),
        ('Queso feta', 14.0, 4.1, 21.0, 260),
        ('Coco rallado', 3.3, 15.2, 33.5, 354),
        ('Lentejas cocidas', 9.0, 20.0, 0.4, 116),
        ('Plátano', 1.3, 27.0, 0.4, 105),
        ('Pepino', 0.6, 2.2, 0.1, 15),
        ('Naranja', 1.0, 12.0, 0.2, 49),
        ('Pimiento verde', 0.9, 3.0, 0.2, 15),
        ('Quinoa cocida', 4.1, 21.3, 1.9, 120), --40
        ('Guisantes cocidos', 5.0, 14.0, 0.2, 81),
        ('Pechuga de pollo', 31.0, 0.0, 3.6, 165),
        ('Fresas', 0.8, 7.7, 0.4, 33),
        ('Yogur natural', 5.0, 4.7, 3.3, 61),
        ('Pimiento amarillo', 1.3, 6.0, 0.2, 27),
        ('Pepinillos en vinagre', 0.9, 3.5, 0.1, 12),
        ('Hojuelas de maíz', 7.5, 88.0, 0.4, 380),
        ('Pera', 0.4, 15.5, 0.1, 57),
        ('Pistachos', 20.6, 27.2, 45.3, 560),
        ('Pimentón', 1.3, 6.0, 0.3, 26),  --50
        ('Cebada cocida', 3.6, 28.0, 0.5, 123),
        ('Almendras', 21.1, 21.7, 49.9, 576),
        ('Tortilla de maíz', 2.7, 19.1, 0.6, 89),
        ('Jengibre fresco', 2.0, 18.0, 0.8, 80),
        ('Miel', 0.3, 82.0, 0.0, 304),
        ('Chorizo', 25.0, 2.0, 30.0, 380),
        ('Aceitunas', 1.0, 6.0, 10.0, 115),
        ('Jamon Serrano', 28.0, 0.0, 10.0, 210),
        ('Pimientos del piquillo', 1.0, 6.0, 0.3, 20),
        ('Pulpo', 19.0, 0.0, 2.0, 82),  --60
        ('Gambas', 20.0, 0.0, 1.0, 85),
        ('Lomo', 30.0, 0.0, 10.0, 200),
        ('Mejillones', 20.0, 5.0, 5.0, 150),
        ('Boquerones', 15.0, 2.0, 10.0, 140),
        ('Aceite de oliva virgen', 0.0, 0.0, 100.0, 884),
        ('Ajo', 1.0, 4.0, 0.0, 20),
        ('Perejil', 3.0, 7.0, 0.5, 45),
        ('Pimientos', 1.0, 9.0, 0.3, 30),
        ('Limón', 0.5, 9.0, 0.1, 30),
        ('Aceitunas rellenas de anchoa', 1.0, 6.0, 10.0, 115);  --70

-- Insertar datos en la tabla de recetas
INSERT INTO recipe (name, calories, steps, image_url)
VALUES
('Tortilla con pavo', 245, 'Batimos el huevo. Calentamos aceite en sarten. echamos huevos batidos a la sarten. echamos el pavo. sacamos de la sarten.', 'https://www.hogarmania.com/archivos/202404/tortilla-de-habitas-tiernas-receta-848x477x80xX.jpg'),
('Pollo con pasta y platano', 650, 'Asamos el pollo. cocemos la pasta. añadimos el platano.', 'https://www.hogarmania.com/archivos/202404/esparragos-blancos-cocidos-salteados-y-crudos-receta-848x477x80xX.jpg'),
('yogurt con nueces', 415, 'Añadimos el yogurt al cuenco. añadimos las nueces. añadimos la miel.', 'https://www.hogarmania.com/archivos/202404/arroz-con-leche-principal-848x477x80xX.jpg'),
('Salmon con ensalada', 457, 'Cocinamos el salmon. mezclamos con la ensalada.', 'https://www.hogarmania.com/archivos/201909/fogonero-tomate-xl-848x477x80xX.jpg');


-- Insertar datos en la tabla de relación ingredient_recipe
INSERT INTO ingredient_recipe (quantity, id_ingredient, id_recipe)
VALUES (2, 1, 1), -- 200 gramos de pollo para la receta 1
       (1, 2, 1), -- 80 gramos de pasta para la receta 1
       (1, 16, 2), -- 100 gramos de huevo para la receta 2
       (1, 5, 2), -- 100 gramos de pechuga de pavo para la receta 2
       (0.5, 20, 3), -- 50 gramos de yogur griego para la receta 3
       (0.5, 24, 3), -- 50 gramos de nueces para la receta 3
       (0.1, 55, 3), -- 10 gramos de miel para la receta 3
       (2, 7, 4), -- 200 gramos de Salmon para la receta 4
       (1, 9, 4), -- 100 gramos de Tomate para la receta 4
       (1, 12, 4); -- 100 gramos de espinacas para la receta 4

-- Insertar datos en la tabla de relación Diet
INSERT INTO diet (name, calories)
VALUES ('Dieta Perdida 1800', 1800);

-- Insertar datos en la tabla de relación recipe_diet
INSERT INTO recipe_diet (id_diet, id_recipe, day_Week, meal_Time)
VALUES
(1, 1, 'LUNES', 'DESAYUNO'),
(1, 2, 'LUNES', 'ALMUERZO'),
(1, 3, 'LUNES', 'SNACK'),
(1, 4, 'LUNES', 'CENA'),
(1, 1, 'JUEVES', 'DESAYUNO'),
(1, 2, 'JUEVES', 'ALMUERZO'),
(1, 3, 'JUEVES', 'SNACK'),
(1, 4, 'JUEVES', 'CENA');






