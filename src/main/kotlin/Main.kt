import java.lang.System.exit
import kotlin.system.exitProcess

fun main() {
    val student = StudentFunctions()

    while (true) {

        println("\n*** Welcome to Student Database Management System ***\n**Please choose from options below: ***")
        println("[A] Add Student \n[B] Edit List \n[C] Delete Student \n[D] Display Student Info \n[E] Exit \nEnter option here: ")
        val inputUser = readLine()

        if (inputUser == "A") {
            student.addStudent()
        } else if (inputUser == "B") {
            student.editStudent()
        } else if (inputUser == "C") {
            student.deleteStudent()

        } else if (inputUser == "D") {
            student.displayStudent()
            print("Do you want to continue(y/n): ")
            val ans = readLine()
            if (ans == "y") {
                continue
            } else if (ans == "n") {
                break
            }
        } else if (inputUser == "E") {
            println("Thank you for using Student Data Management system")
            break
        } else {
            println("Invalid entry, please use Big caps")
        }
    }
}



