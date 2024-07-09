package com.app.panaderiaplus.data

import com.app.panaderiaplus.R

interface FuentePanes {
    fun getPanesRegistrados(): List<Pan>
}

class PanesBD : FuentePanes {

override fun getPanesRegistrados(): List<Pan> {
        return mutableListOf(
            Pan(
                id = 1L,
                name = "Pan de Manteca",
                imageUrl = R.drawable.pan_manteca,
                description = "Pan suave y esponjoso, perfecto para el desayuno ",
                ingredients = "Harina de trigo, mantequilla, leche, azúcar, sal, levadura",
                orderDescription = "120 kcal",
                price = 0.5,
                isFavourite = false
            ),
            Pan(
                id = 2L,
                name = "Pan dulce",
                imageUrl = R.drawable.pan_sweet,
                description = "Pan ligeramente dulce con una corteza crujiente.",
                ingredients = "Harina de trigo, azúcar, mantequilla, huevos, leche, levadura, sal",
                orderDescription = "150 kcal",
                price = 0.6,
                isFavourite = false
            ),
            Pan(
                id = 3L,
                name = "Pan de queso",
                imageUrl = R.drawable.pan_cheese,
                description = "Pan relleno de queso, ideal para acompañar el café.",
                ingredients = "Harina de trigo, queso, mantequilla, leche, azúcar, sal, levadura. ",
                orderDescription = "200 kcal",
                price = 1.0,
                isFavourite = false
            ),
            Pan(
                id = 4L,
                name = "Pastel de chocolate",
                imageUrl = R.drawable.pastel_chocolate,
                description = "Pastel esponjoso de chocolate, cubierto con glaseado de chocolate.",
                ingredients = "Harina de trigo, azúcar, cacao en polvo, mantequilla, huevos, leche, polvo de hornear, vainilla. ",
                orderDescription = "350 kcal",
                price = 12.5,
                isFavourite = false
            ),
            Pan(
                id = 5L,
                name = "Torta de Zanahoria",
                imageUrl = R.drawable.carrot_cake,
                description = "Torta húmeda de zanahoria con un toque de canela y nueces",
                ingredients = "Harina de trigo, zanahorias ralladas, azúcar, aceite, huevos, nueces, canela, bicarbonato de sodio. ",
                orderDescription = "300 kcal",
                price = 15.0,
                isFavourite = false
            ),
            Pan(
                id = 6L,
                name = "Empanada de carne",
                imageUrl = R.drawable.empanada_de_carne,
                description = ": Empanada rellena de carne sazonada y vegetales",
                ingredients = "Harina de trigo, carne molida, cebolla, pimiento, aceite, comino, sal, levadura",
                orderDescription = "200 kcal",
                price = 1.5,
                isFavourite = false
            ),
            Pan(
                id = 7L,
                name = "Croissant",
                imageUrl = R.drawable.croissant,
                description = "Bollería francesa, crujiente por fuera y suave por dentro",
                ingredients = "Harina de trigo, mantequilla, leche, azúcar, sal, levadura.",
                orderDescription = "120 kcal",
                price = 0.60,
                isFavourite = false
            ),
            Pan(
                id = 8L,
                name = "Muffin de Arandanos",
                imageUrl = R.drawable.muffin_blueberry,
                description = "Muffin esponjoso con arándanos frescos",
                ingredients = "Harina de trigo, azúcar, arándanos, mantequilla, huevos, leche, polvo de hornear, sal. ",
                orderDescription = "220 kcal",
                price = 1.8,
                isFavourite = false
            ),
            Pan(
                id = 9L,
                name = "Galletas de avena",
                imageUrl = R.drawable.galletas_de_avena,
                description = "Latte Macchiato is a coffee beverage; the name literally means stained milk.",
                ingredients = "Espresso, Milk, Milk foam, Flavoured coffee syrup",
                orderDescription = "300 ml",
                price = 0.5,
                isFavourite = false
            ),
            Pan(
                id = 10L,
                name = "Brownie de nueces",
                imageUrl = R.drawable.brownie_walnut,
                description = "Galletas crujientes con un toque de canela y pasas",
                ingredients = "Avena, harina de trigo, azúcar, mantequilla, huevos, canela, pasas, bicarbonato de sodio",
                orderDescription = "150 kcal",
                price = 1.5,
                isFavourite = false
            )
        )
    }
}
