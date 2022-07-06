import kotlin.system.exitProcess

class StudentFunctions : SDMSFunctions {

    var studentList = mutableListOf(
        StudentDetails("ID123", "Tony Stark", 22, "Male"),
        StudentDetails("ID122", "Steve Rogers", 23, "Male"),
        StudentDetails("ID111", "Natasha Romanov", 20, "Female"),
        StudentDetails("ID141", "Thor Odinson", 25, "Male")
    )
    private val size = studentList.size
    var ctr = 0

    override fun addStudent() {
        print("Enter Name: ")
        val nameNew = readLine()
        print("Enter Age: ")
        val ageNew = Integer.valueOf(readLine())
        print("Enter Gender: ")
        val genderNew = readLine()

        val store = studentList.last()
        val idNew = store.id + 1

        val addNew = StudentDetails(id = idNew, name = "$nameNew", age = ageNew, gender = "$genderNew")
  //      studentList.add(index = studentList.size, addNew)
        studentList.add(index = size, addNew)
        println("Student $nameNew has been add to the list")
        println("Would you like to go back to the main option?: Y/N")
        when (readLine()) {
            "Y" -> main()
            "N" -> exitProcess(-1)
            else -> {
                println("Invalid entry, please use Big caps")
                main()
            }
        }
    }

    override fun editStudent() {

        print("Enter ID: ")
        val idNew = (readLine())

        for (index in studentList) {
            if (index.id == idNew) {
                println("This is the Student Info")
                println(index)
                print("Do you want to edit?(y/n)")
                val ans = readLine()
                if (ans == "y") {
                    print("Enter Name: ")
                    val nameNew = readLine()
                    print("Enter Age: ")
                    val ageNew = Integer.valueOf(readLine())
                    print("Enter Gender: ")
                    val genderNew = readLine()

                    index.name = nameNew.toString()
                    index.age = ageNew
                    index.gender = genderNew.toString()

                } else if (ans == "n") {
                    continue
                }
                println("Would you like to go back to the main option?: Y/N")
                when (readLine()) {
                    "Y" -> main()
                    "N" -> exitProcess(-1)
                    else -> {
                    println("Invalid entry, please use Big caps")
                    main()
                    }
                }
            }
        }
    }

    override fun deleteStudent() {

        print("Enter ID: ")
        val idNew = (readLine())

        while (ctr != size) {
            if (studentList[ctr].id == idNew) {
                println("This is the Student Info")
                println(studentList[ctr])
                print("Do you want to delete?(y/n)")
                val ans = readLine()
                if (ans == "y") {

                    studentList.removeAt(index = ctr)
                } else if (ans == "n") {
                    continue
                }
            }
            ctr++
        }
        when (readLine()) {
            "Y" -> main()
            "N" -> exitProcess(-1)
            else -> {
                println("Invalid entry, please use Big caps")
                main()
            }
        }
    }

    override fun displayStudent() {

        println("Display All Students")
        for (index in studentList) {
            println("ID: ${index.id}, Name: ${index.name}, Age: ${index.age}, Gender: ${index.gender}")

        }
        println("Do you have another transaction? y/n")
        val ans = readLine()
        if (ans == "y") {
            println("What would you like to do?")
            println("[a] Return to Main Options \n[b] Search Student")
            when (readLine()) {
                "a" -> {
                    return main()
                }
                "b" -> {
                    print("Enter Student ID: ")
                    val idNew = readLine()

                    while (ctr != size) {
                        val stor = studentList[ctr].name.contains(idNew.toString())
                        println(stor)
                        ctr++
                    }

                    while (ctr != size) {
                        if (studentList[ctr].id == idNew) {
                            println("This is the Student Info")
                            println(studentList[ctr])
                        }
                        ctr++
                    }
                }
                else -> {
                    println("Invalid input")
                    displayStudent()
                }
            }
        }
     }

    override fun exit() {
        println("Do you want to exit?: y/n")
        when (readLine()) {
            "y" -> {
                println("Thank you for using Student Data Management system")
                exitProcess(-1)
            }
            "n" -> {
                return main()
            }
            else -> {
                println("Invalid entry")
                exit()
            }
        }
    }
}

