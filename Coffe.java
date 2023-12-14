import java.util.*

class CoffeeMachine {
    private var scanner = Scanner(System.`in`)
    
    var water: Int = 0
    var milk: Int = 0
    var beans: Int = 0

    // Начните написание программы с публичной функции start().
    // В этот раз мы не даём вам конкретных указаний, как должна быть написана программа.
    // У вас есть полная свобода действией, главное, что бы программа соответствовала ТЗ.
    // Удачи!
    
    fun start() {
        println("Кофемашина готова к работе")
        while (true) {
        println("Введите команду")
        var enter = scanner.nextLine()
        when(enter.lowercase()) {
            "выключить" -> {
                println("До свидания!")
                break
            }
            "наполнить" -> { fill() }
            "статус" -> { status() }
            "кофе" -> { enterCoffee() }
            else -> println("Неизвестная команда")
            
        }
        }
    }
        
    fun enterCoffee() {

        println("Введите название напитка или \"назад\" для возврата в главное меню")
        var coffeType = scanner.nextLine()
        when(coffeType.lowercase()) {
        "назад" -> { return }
        "эспрессо" -> { cookCoffee(CoffeRecipe.ESPRESSO) }
        "американо" -> { cookCoffee(CoffeRecipe.AMERICANO) }
        "капучино" -> { cookCoffee(CoffeRecipe.CAPPUCHINO) }
        "латте" -> { cookCoffee(CoffeRecipe.LATTE) }
        else -> { println("Рецепт не найден!")}
        }

   }
    
    fun fill() {
        this.water += (2000 - this.water)
        this.milk += (1000 - this.milk)
        this.beans += (500 - this.beans)
        println("Ингридиенты пополнены")
        
    }
    
    fun status() {
        println("Ингридиентов осталось: ")
        println("${this.water} мл воды\n${this.milk} мл молока\n${this.beans} гр кофе")
    }
    
    fun cookCoffee(coffeRecipe: CoffeRecipe) {
        if (this.water < coffeRecipe.water) {
            println("Недостаточно воды!")
            return
        } else if (this.milk < coffeRecipe.milk) {
            println("Недостаточно молока!")
            return
        } else if (this.beans < coffeRecipe.beans) {
            println("Недостаточно кофе!")
            return
        }
        
        this.water -= coffeRecipe.water
        this.milk -= coffeRecipe.milk
        this.beans -= coffeRecipe.beans
        println("${coffeRecipe.coffeeName} готов")
    } 
          
}

    enum class CoffeRecipe(val coffeeName: String, val water: Int, val milk: Int, val beans: Int) {
        ESPRESSO("Эспрессо", 60, 0, 10),
        AMERICANO("Американо", 120, 0, 10),
        CAPPUCHINO("Капучино", 120, 60, 20),
        LATTE("Латте", 240, 120, 20);
    }