package com.app.panaderiaplus.data

import com.app.panaderiaplus.R

interface FuentePanes {
    fun getPanesRegistrados(): List<Pan>
}

class PanesBD : FuentePanes {

    override fun getPanesRegistrados(): List<Pan> {
        return mutableListOf(
            Pan(
                id = 10L,
                name = "Brownie de nueces",
                imageUrl = R.drawable.brownie_transparent,
                description = "Brownies horneados con nueces , altos en proteina",
                ingredients = "Chocolate negro 90% puro, cacao en polvo, huevos de granja, mantequilla fresca (no margarina), sal de mar, harina de centeno y proteina de leche",
                orderDescription = "150 kcal",
                price = 1.5,
                isFavourite = false,
                category = "postres"
            ),
            Pan(
                id = 1L,
                name = "Pan de Manteca",
                imageUrl = R.drawable.pan_manteca,
                description = "Pan suave y esponjoso, perfecto para el desayuno ",
                ingredients = "Harina de trigo, mantequilla, leche, azúcar, sal, levadura",
                orderDescription = "120 kcal",
                price = 0.5,
                isFavourite = false,
                category = "panes"
            ),
            Pan(
                id = 2L,
                name = "Pan dulce",
                imageUrl = R.drawable.pan_sweet,
                description = "Pan ligeramente dulce con una corteza crujiente.",
                ingredients = "Harina de trigo, azúcar, mantequilla, huevos, leche, levadura, sal",
                orderDescription = "150 kcal",
                price = 0.6,
                isFavourite = false,
                category = "panes"
            ),
            Pan(
                id = 3L,
                name = "Pan de queso",
                imageUrl = R.drawable.pan_cheese,
                description = "Pan relleno de queso, ideal para acompañar el café.",
                ingredients = "Harina de trigo, queso, mantequilla, leche, azúcar, sal, levadura. ",
                orderDescription = "200 kcal",
                price = 1.0,
                isFavourite = false,
                category = "panes"
            ),
            Pan(
                id = 4L,
                name = "Pastel de chocolate",
                imageUrl = R.drawable.chocolate_cake,
                description = "Pastel esponjoso de chocolate, cubierto con glaseado de chocolate.",
                ingredients = "Harina de trigo, azúcar, cacao en polvo, mantequilla, huevos, leche, polvo de hornear, vainilla. ",
                orderDescription = "350 kcal",
                price = 12.5,
                isFavourite = false,
                category = "postres"
            ),
            Pan(
                id = 5L,
                name = "Torta de Zanahoria",
                imageUrl = R.drawable.carrot_cake,
                description = "Torta húmeda de zanahoria con un toque de canela y nueces",
                ingredients = "Harina de trigo, zanahorias ralladas, azúcar, aceite, huevos, nueces, canela, bicarbonato de sodio. ",
                orderDescription = "300 kcal",
                price = 15.0,
                isFavourite = false,
                category = "postres"
            ),
            Pan(
                id = 6L,
                name = "Empanada de carne",
                imageUrl = R.drawable.empanada_de_carne,
                description = ": Empanada rellena de carne sazonada y vegetales",
                ingredients = "Harina de trigo, carne molida, cebolla, pimiento, aceite, comino, sal, levadura",
                orderDescription = "200 kcal",
                price = 1.5,
                isFavourite = false,
                category = "otro"
            ),
            Pan(
                id = 7L,
                name = "Croissant",
                imageUrl = R.drawable.croissant,
                description = "Bollería francesa, crujiente por fuera y suave por dentro",
                ingredients = "Harina de trigo, mantequilla, leche, azúcar, sal, levadura.",
                orderDescription = "120 kcal",
                price = 0.60,
                isFavourite = false,
                category = "panes"
            ),
            Pan(
                id = 8L,
                name = "Muffin de Arandanos",
                imageUrl = R.drawable.muffin_blueberry,
                description = "Muffin esponjoso con arándanos frescos",
                ingredients = "Harina de trigo, azúcar, arándanos, mantequilla, huevos, leche, polvo de hornear, sal. ",
                orderDescription = "220 kcal",
                price = 1.8,
                isFavourite = false,
                category = "postre"
            ),
            Pan(
                id = 9L,
                name = "Galletas de avena",
                imageUrl = R.drawable.galletas_de_avena,
                description = "Galletas crujientes con un toque de canela y pasas",
                ingredients = "Avena, harina de trigo, azúcar, mantequilla, huevos, canela, pasas, bicarbonato de sodio",
                orderDescription = "300 ml",
                price = 0.5,
                isFavourite = false,
                category = "otro"
            ),
            Pan(
                id = 11L,
                name = "Café Expreso",
                imageUrl = R.drawable.cafe_expresso,
                description = "Café expreso fuerte y concentrado, perfecto para comenzar el día.",
                ingredients = "Café",
                orderDescription = "1 taza",
                price = 2.5,
                isFavourite = false,
                category = "bebidas"
            ),

            Pan(
                id = 12L,
                name = "Café Americano",
                imageUrl = R.drawable.cafe_americano,
                description = "Café americano suave, preparado con agua caliente y un shot de expreso.",
                ingredients = "Café, agua",
                orderDescription = "1 taza",
                price = 2.0,
                isFavourite = false,
                category = "bebidas"
            ),

            Pan(
                id = 13L,
                name = "Cappuccino",
                imageUrl = R.drawable.cappuccino,
                description = "Café cappuccino cremoso con una capa de espuma de leche.",
                ingredients = "Café, leche, espuma de leche",
                orderDescription = "1 taza",
                price = 3.0,
                isFavourite = false,
                category = "bebidas"
            ),

            Pan(
                id = 14L,
                name = "Latte",
                imageUrl = R.drawable.latte,
                description = "Café latte suave y cremoso con un toque de leche al vapor.",
                ingredients = "Café, leche",
                orderDescription = "1 taza",
                price = 2.75,
                isFavourite = false,
                category = "bebidas"
            ),

            Pan(
                id = 15L,
                name = "Té Verde",
                imageUrl = R.drawable.te_verde,
                description = "Té verde refrescante y saludable, rico en antioxidantes.",
                ingredients = "Té verde",
                orderDescription = "1 taza",
                price = 2.0,
                isFavourite = false,
                category = "bebidas"
            ),

            Pan(
                id = 16L,
                name = "Té Negro",
                imageUrl = R.drawable.te_negro,
                description = "Té negro fuerte y aromático, perfecto para cualquier momento del día.",
                ingredients = "Té negro",
                orderDescription = "1 taza",
                price = 2.0,
                isFavourite = false,
                category = "bebidas"
            ),

            Pan(
                id = 17L,
                name = "Té de Frutos rojos",
                imageUrl = R.drawable.te_frutos_rojos,
                description = "Té de frutos rojos endulzado con stevia.",
                ingredients = "Mezcla de frutos rojos, té",
                orderDescription = "1 taza",
                price = 2.0,
                isFavourite = false,
                category = "bebidas"
            ),

            Pan(
                id = 18L,
                name = "Chocolate Caliente",
                imageUrl = R.drawable.chocolate_caliente,
                description = "Chocolate caliente cremoso, perfecto para los días fríos.",
                ingredients = "Leche, cacao, azúcar",
                orderDescription = "1 taza",
                price = 1.5,
                isFavourite = false,
                category = "bebidas"
            ),

            Pan(
                id = 19L,
                name = "Agua Mineral",
                imageUrl = R.drawable.agua_mineral,
                description = "Agua mineral refrescante, ideal para acompañar tus comidas.",
                ingredients = "Agua mineral",
                orderDescription = "1 botella de 500ml",
                price = 0.60,
                isFavourite = false,
                category = "bebidas"
            ),

            Pan(
                id = 20L,
                name = "Limonada",
                imageUrl = R.drawable.limonada,
                description = "Limonada fresca y refrescante, perfecta para un día caluroso.",
                ingredients = "Agua, limón, azúcar",
                orderDescription = "1 vaso mediano",
                price = 1.5,
                isFavourite = false,
                category = "bebidas"
            ),

            Pan(
                id = 21L,
                name = "Coca-Cola-Familiar",
                imageUrl = R.drawable.coca_familiar,
                description = "Bebida refrescante.",
                ingredients = "Azúcar y colorante",
                orderDescription = "envase familiar de 1.35 ml",
                price = 1.50,
                isFavourite = false,
                category = "bebidas"
            ),

            Pan(
                id = 22L,
                name = "Pastel de Chocolate",
                imageUrl = R.drawable.pastel_chocolate,
                description = "Delicioso pastel de chocolate con capas de esponjoso bizcocho y crema de chocolate.",
                ingredients = "Harina, azúcar, cacao, huevos, mantequilla, crema de chocolate",
                orderDescription = "1 pastel de chocolate - 10 porciones",
                price = 15.0,
                isFavourite = false,
                category = "postres"
            ),

            Pan(
                id = 23L,
                name = "Pastel de Vainilla",
                imageUrl = R.drawable.pastel_vainilla,
                description = "Clásico pastel de vainilla con un suave bizcocho y crema de vainilla.",
                ingredients = "Harina, azúcar, huevos, mantequilla, crema de vainilla",
                orderDescription = "1 pastel de vainilla - 10 porciones",
                price = 14.0,
                isFavourite = false,
                category = "postres"
            ),

            Pan(
                id = 24L,
                name = "Tarta de Manzana",
                imageUrl = R.drawable.pastel_manzana,
                description = "Tarta de manzana con un relleno dulce de manzanas y canela.",
                ingredients = "Harina, azúcar, manzanas, canela, mantequilla",
                orderDescription = "1 tarta de manzana - 8 porciones",
                price = 12.0,
                isFavourite = false,
                category = "postres"
            ),

            Pan(
                id = 25L,
                name = "Tarta de Fresa",
                imageUrl = R.drawable.pastel_fresa,
                description = "Tarta fresca de fresa con una base crujiente y crema pastelera.",
                ingredients = "Harina, azúcar, fresas, crema pastelera, mantequilla",
                orderDescription = "1 tarta de fresas - 8 porciones",
                price = 13.0,
                isFavourite = false,
                category = "postres"
            ),

            Pan(
                id = 26L,
                name = "Pastel de naranja",
                imageUrl = R.drawable.paste_naranja,
                description = "Suave tarta de queso con una base de galleta crujiente.",
                ingredients = "Queso crema, azúcar, huevos, galletas, mantequilla",
                orderDescription = "1 pastel de naranja - 10 porciones",
                price = 14.0,
                isFavourite = false,
                category = "postres"
            ),
            Pan(
                id = 27L,
                name = "Tarta de Limón",
                imageUrl = R.drawable.tarta_limon,
                description = "Tarta de limón con un relleno cremoso y un toque de merengue.",
                ingredients = "Harina, azúcar, limón, huevos, mantequilla, merengue",
                orderDescription = "1 tarta",
                price = 13.0,
                isFavourite = false,
                category = "postres"
            ),

            Pan(
                id = 28L,
                name = "Donas Glaseadas",
                imageUrl = R.drawable.donas_glaseadas,
                description = "Donas suaves y esponjosas con un glaseado dulce.",
                ingredients = "Harina, azúcar, leche, huevos, mantequilla, glaseado",
                orderDescription = "1 dona",
                price = 1.5,
                isFavourite = false,
                category = "postres"
            ),

            Pan(
                id = 29L,
                name = "Donas de Chocolate",
                imageUrl = R.drawable.donas_chocolate,
                description = "Donas suaves cubiertas con un glaseado de chocolate.",
                ingredients = "Harina, azúcar, leche, huevos, mantequilla, glaseado de chocolate",
                orderDescription = "1 dona",
                price = 1.5,
                isFavourite = false,
                category = "postres"
            ),

            Pan(
                id = 30L,
                name = "Galletas de Chispas de Chocolate",
                imageUrl = R.drawable.galletas_chocolate,
                description = "Galletas crujientes con deliciosas chispas de chocolate.",
                ingredients = "Harina, azúcar, mantequilla, chispas de chocolate, huevos",
                orderDescription = "1 paquete de 6 unidades",
                price = 1.0,
                isFavourite = false,
                category = "postres"
            ),

            Pan(
                id = 31L,
                name = "Galletas de Avena",
                imageUrl = R.drawable.galletas_avena,
                description = "Galletas saludables y crujientes hechas con avena.",
                ingredients = "Avena, harina, azúcar, mantequilla, huevos",
                orderDescription = "1 paquete de 6 unidades",
                price = 1.0,
                isFavourite = false,
                category = "postres"
            ),

            Pan(
                id = 32L,
                name = "Galletas de Mantequilla",
                imageUrl = R.drawable.galletas_mantequilla,
                description = "Galletas suaves y deliciosas con un sabor rico a mantequilla.",
                ingredients = "Harina, azúcar, mantequilla, huevos",
                orderDescription = "1 paquete de 6 unidades",
                price = 1.0,
                isFavourite = false,
                category = "postres"
            ),

            Pan(
                id = 33L,
                name = "Croissants Rellenos de Chocolate",
                imageUrl = R.drawable.croissants_chocolate,
                description = "Croissants crujientes rellenos con chocolate fundido.",
                ingredients = "Harina, mantequilla, azúcar, chocolate, levadura",
                orderDescription = "1 croissant",
                price = 1.75,
                isFavourite = false,
                category = "postres"
            ),

            Pan(
                id = 34L,
                name = "Croissants Rellenos de Crema",
                imageUrl = R.drawable.croissants_crema,
                description = "Croissants crujientes rellenos con crema pastelera.",
                ingredients = "Harina, mantequilla, azúcar, crema pastelera, levadura",
                orderDescription = "1 croissant",
                price = 1.75,
                isFavourite = false,
                category = "postres"
            ),

            Pan(
                id = 35L,
                name = "Salchicha de Carne",
                imageUrl = R.drawable.salchichas_carne,
                description = "Salchichas elaboradas con carne de res, ideales para parrilladas y desayunos.",
                ingredients = "Carne de res, especias",
                orderDescription = "1000 g",
                price = 1.0,
                isFavourite = false,
                category = "embutidos"
            ),

            Pan(
                id = 36L,
                name = "Salchicha de Pollo",
                imageUrl = R.drawable.salchichas_carne,
                description = "Salchichas ligeras hechas de carne de pollo, perfectas para una opción más saludable.",
                ingredients = "Carne de pollo, especias",
                orderDescription = "500 g",
                price = 0.6,
                isFavourite = false,
                category = "embutidos"
            ),

            Pan(
                id = 37L,
                name = "Mortadela de Carne",
                imageUrl = R.drawable.mortadela_carne,
                description = "Mortadela tradicional hecha con carne de res, un clásico para sándwiches.",
                ingredients = "Carne de res, especias",
                orderDescription = "170 g",
                price = 0.60,
                isFavourite = false,
                category = "embutidos"
            ),

            Pan(
                id = 38L,
                name = "Mortadela de Pollo",
                imageUrl = R.drawable.mortadela_pollo,
                description = "Mortadela ligera hecha con carne de pollo, perfecta para una opción más saludable.",
                ingredients = "Carne de pollo, especias",
                orderDescription = "170 g",
                price = 0.6,
                isFavourite = false,
                category = "embutidos"
            ),
            Pan(
                id = 39L,
                name = "Jamón",
                imageUrl = R.drawable.jamon,
                description = "Jamón de alta calidad, ideal para sándwiches y ensaladas.",
                ingredients = "Carne de cerdo, especias",
                orderDescription = "120 g",
                price = 0.6,
                isFavourite = false,
                category = "embutidos"
            ),
            Pan(
                id = 40L,
                name = "Leche Descremada",
                imageUrl = R.drawable.leche_descremada,
                description = "Leche descremada, ideal para una dieta baja en grasas.",
                ingredients = "Leche descremada",
                orderDescription = "1 litro",
                price = 0.95,
                isFavourite = false,
                category = "lacteos"
            ),

            Pan(
                id = 41L,
                name = "Leche Entera",
                imageUrl = R.drawable.leche_entera,
                description = "Leche entera, rica en nutrientes y perfecta para toda la familia.",
                ingredients = "Leche entera",
                orderDescription = "1 litro",
                price = 0.95,
                isFavourite = false,
                category = "lacteos"
            ),

            Pan(
                id = 42L,
                name = "Leche Semidescremada",
                imageUrl = R.drawable.leche_semidescremada,
                description = "Leche semidescremada, el equilibrio perfecto entre sabor y salud.",
                ingredients = "Leche semidescremada",
                orderDescription = "1 litro",
                price = 0.95,
                isFavourite = false,
                category = "lacteos"
            ),

            Pan(
                id = 43L,
                name = "Yogurt de Fresa",
                imageUrl = R.drawable.yogurt_fresa,
                description = "Yogurt cremoso con sabor a fresa, ideal para desayunos y meriendas.",
                ingredients = "Leche, fresa, azúcar, cultivos lácticos",
                orderDescription = "botella de yougurt de 200 g",
                price = 0.8,
                isFavourite = false,
                category = "lacteos"
            ),

            Pan(
                id = 44L,
                name = "Yogurt de Mora",
                imageUrl = R.drawable.yogurt_mora,
                description = "Yogurt cremoso con sabor a mora, perfecto para una merienda saludable.",
                ingredients = "Leche, mora, azúcar, cultivos lácticos",
                orderDescription = "botella de yougurt de 200 g",
                price = 0.8,
                isFavourite = false,
                category = "lacteos"
            ),

            Pan(
                id = 45L,
                name = "Yogurt de Durazno",
                imageUrl = R.drawable.yogurt_durazno,
                description = "Yogurt cremoso con sabor a durazno, ideal para un desayuno rápido.",
                ingredients = "Leche, durazno, azúcar, cultivos lácticos",
                orderDescription = "botella de yougurt de 200 g",
                price = 0.8,
                isFavourite = false,
                category = "lacteos"
            ),

            Pan(
                id = 46L,
                name = "Queso Cheddar",
                imageUrl = R.drawable.queso_chedar,
                description = "Queso cheddar de sabor fuerte y textura firme, perfecto para hamburguesas y nachos.",
                ingredients = "Leche de vaca, sal, cultivos lácticos",
                orderDescription = "200 g",
                price = 1.30,
                isFavourite = false,
                category = "lacteos"
            ),

            Pan(
                id = 47L,
                name = "Queso Crema",
                imageUrl = R.drawable.queso_crema,
                description = "Queso crema suave y cremoso, ideal para untar en galletas, pan, etc.",
                ingredients = "Leche de vaca, sal, cultivos lácticos",
                orderDescription = "200 g",
                price = 2.0,
                isFavourite = false,
                category = "lacteos"
            ),

            Pan(
                id = 48L,
                name = "Queso Parmesano",
                imageUrl = R.drawable.queso_parmesano,
                description = "Queso parmesano envejecido, con un sabor intenso y textura granulada, perfecto para pastas.",
                ingredients = "Leche de vaca, sal, cultivos lácticos",
                orderDescription = "200 g",
                price = 6.0,
                isFavourite = false,
                category = "lacteos"
            ),

            Pan(
                id = 49L,
                name = "Mermelada de Fresa",
                imageUrl = R.drawable.mermelada_fresa,
                description = "Mermelada de fresa casera, perfecta para untar en tus panes y tostadas.",
                ingredients = "Fresas, azúcar, limón",
                orderDescription = "1 frasco de 300g ",
                price = 2.50,
                isFavourite = false,
                category = "otros"
            ),

            Pan(
                id = 50L,
                name = "Mermelada de Manzana",
                imageUrl = R.drawable.mermelada_manzana,
                description = "Mermelada de manzana casera, ideal para acompañar tus desayunos.",
                ingredients = "Manzanas, azúcar, limón",
                orderDescription = "1 frasco de 300g ",
                price = 2.50,
                isFavourite = false,
                category = "otros"
            ),

            Pan(
                id = 51L,
                name = "Mermelada de Naranja",
                imageUrl = R.drawable.mermelada_naranja,
                description = "Mermelada de naranja casera, perfecta para un toque cítrico en tus comidas.",
                ingredients = "Naranjas, azúcar, limón",
                orderDescription = "1 frasco de 300g ",
                price = 2.50,
                isFavourite = false,
                category = "otros"
            ),

            Pan(
                id = 52L,
                name = "Mantequilla",
                imageUrl = R.drawable.mantequilla,
                description = "Mantequilla fresca y cremosa, perfecta para untar o cocinar.",
                ingredients = "Leche, sal",
                orderDescription = "1 paquete de 100 gr",
                price = 1.90,
                isFavourite = false,
                category = "otros"
            ),

            Pan(
                id = 53L,
                name = "Nutella",
                imageUrl = R.drawable.nutella,
                description = "Crema de avellanas y chocolate, ideal para untar en pan o como ingrediente en postres.",
                ingredients = "Avellanas, cacao, azúcar, leche",
                orderDescription = "1 frasco de 200 gr",
                price = 4.80,
                isFavourite = false,
                category = "otros"
            ),

            Pan(
                id = 54L,
                name = "Miel",
                imageUrl = R.drawable.miel,
                description = "Miel pura y natural, perfecta para endulzar tus bebidas y alimentos.",
                ingredients = "Miel",
                orderDescription = "1 frasco de 600 gr",
                price = 2.50,
                isFavourite = false,
                category = "otros"
            ),

            Pan(
                id = 55L,
                name = "Empanadas de Carne",
                imageUrl = R.drawable.empanada_carne,
                description = "Empanadas rellenas de carne, ideales para una merienda o comida rápida.",
                ingredients = "Harina, carne, especias, cebolla",
                orderDescription = "1 empanada",
                price = 0.45,
                isFavourite = false,
                category = "otros"
            ),

            Pan(
                id = 56L,
                name = "Empanadas de Pollo",
                imageUrl = R.drawable.empanadas_pollo,
                description = "Empanadas rellenas de pollo, perfectas para una comida ligera.",
                ingredients = "Harina, pollo, especias, cebolla",
                orderDescription = "1 empanada",
                price = 0.45,
                isFavourite = false,
                category = "otros"
            ),
            Pan(
                id = 57L,
                name = "Coca-Cola-Personal",
                imageUrl = R.drawable.coca_vidrio,
                description = "Bebida refrescante.",
                ingredients = "Azúcar y colorante",
                orderDescription = "Personal envase de vidrio de 350 ml",
                price = 0.35,
                isFavourite = false,
                category = "bebidas"
            ),
            Pan(
                id = 58L,
                name = "Coca-Cola-Mediana",
                imageUrl = R.drawable.coca_plastico,
                description = "Bebida refrescante.",
                ingredients = "Azúcar y colorante",
                orderDescription = "Personal envase de plastico de 500 ml",
                price = 0.70,
                isFavourite = false,
                category = "bebidas"
            ),


            )
    }
}
