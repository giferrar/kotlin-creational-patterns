# 🧑‍🏫 Learn Creational Patterns with Kotlin

## Introduction

The purpose of this workshop is to have a general overview of how classes and objects works in Kotlin while learning Creational Patterns. We will perform some hands on exercises that can be completed alone or in pair programming. As always, you can find all the solutions of the exercises in the ‘solutions’ branch of the project.

## 📖 Agenda

1. [Classes and Objects](#classes-and-objects)
   1. [Constructors, Properties and Initializer Blocks](#constructors-properties-and-initializer-blocks)
   2. [Nested Classes, Inner Classes and Companion Objects](#nested-classes-inner-classes-and-companion-objects)
   3. [Data Classes](#data-classes)
2. [Creational Patterns](#creational-patterns)
   1. [Factory Method Pattern](#factory-method-pattern)
   2. [Abstract Factory Pattern](#abstract-factory-pattern)
   3. [Builder Pattern](#builder-pattern)
   4. [Singleton Pattern](#singleton-pattern)
   5. [Prototype Pattern](#prototype-pattern)


## Classes and Objects

First of all we will introduce some general concepts about Classes and Objects in Kotlin. This chapter is meant to be a bit theoretical, but you will learn some concepts that will be useful in the implementation of Creational Patterns in Kotlin.

We will skip on purpose some topics that are not related with the main topic of the Workshop (this is not an introduction to Kotlin course). If you want to learn about those topics, go to the official documentation.

### Constructors, Properties and Initializer Blocks

Classes are defined by the modifier ‘class’ and are formed by a name, header and body. The header includes the primary constructor and its properties and their types, while the body is delimited by curly braces and can contain variables and functions among others . Both header and body are optional.

```kotlin
class Person(val name: String, val surname: String, var age: Int = 18) {

    private var employed: Boolean = false

    constructor(name: String, surname: String, age: Int, employed: Boolean) : this(name, surname, age) {
        this.employed = employed
    }

    init {
        println("Person created with name $name $surname and age $age. $name is ${if (employed) "" else "not "}employed")
    }
}
```

In the example above you can see how in the primary constructor you can define properties as mutable (var) or immutable (val) and assign default values.

The body of a class can include secondary constructors. They must be defined by the modifier ‘constructor’ (that is optional for the primary constructor) and, in case the primary constructor is present, must delegate to it.

The body of a class can include ‘init’ blocks containing code that will be executed during the initialization of an object. These blocks are executed as part of the primary constructor. This means secondary constructors are the last to be executed.

---
#### 🧩 Exercise 1
1) Copy the `Person` class above inside `Main.kt` and create the following object instances:
```kotlin
    Person("John", "Doe") // Please note how optional parameters help reduce method overloading
    Person("Bob", "Doe", 25)
    Person("Moe", "Doe", 40, true)
```
What do you notice if you run the program?

2) Create a new constructor in the `Person` class that takes a boolean parameter `retired`. The constructor should delegate to the previous one. The new constructor should print if the person is employed or not and if it is retired or not.
Create the following object instance:
```kotlin
    Person("Klaus", "Doe", 70, false, true)
```

3) Create an extra `println` inside the existing constructors as well as in the beginning of the class. Before running the program, can you guess in which order will the messages be printed?

---
Note also that a constructor can be called with named parameters, as follows:

        Person(surname = "Jones", name = "Indiana")

A parameter can be defined as nullable by adding a question mark after the type, as follows:

        val name: String? = null

Using the question mark after the type can avoid NullPointerExceptions:
    
        assertThat(p.address?.length, `is`(null))


### Nested Classes, Inner Classes and Companion Objects

In Kotlin, it is possible to write classes inside other classes, in a similar way as in Java.

When a Class is defined inside another one, it is called nested. It can be accessed through its outer class in the same way as other members. A limitation of nested classes is that it is not possible to access other members of the outer class from the nested class. To solve this issue the nested class has to be marked as ‘inner’:

```kotlin
class OuterClass {
    val something: String = "fishy"

    class NestedClass {
        // From here 'something' is not visible
    }

    inner class InnerClass {
        fun something(): String = something
    }
}

// Usage
assertThat(OuterClass().InnerClass().something()).isEqualTo("fishy")
```

Companion objects works in a similar way as inner classes, but they are used to define functions and properties that are class level. In this way you can access them directly from the outer class without the need of a class instance. This is often used to write factory methods:

```kotlin
class OuterClass {
    // Name can be omitted
    companion object Factory {
        fun create(): OuterClass = OuterClass()
    }
}

// Usage
val classInstance = OuterClass.create()
```

### Data Classes

In Kotlin data classes (defined with the modifier ‘data class’) are used to hold data and perform basic operations. They must have a primary constructor with at least one parameter and cannot be abstract.

Some particularities of these kinds of classes are:
- Component methods: the compiler generates component methods to access the corresponding property in the same order in which are declared in the primary constructor. To exclude some parameters from the creation of these methods, they have to be included in the body of the class.
- They possess a ‘copy’ method, used to create a new instance of the class with the same or new parameters.
- Destructuring declarations: these classes can be decomposed into values that compose their properties.

```kotlin
data class Person(val name: String, val surname: String, val age: Int)

// Instantiate
val person = Person("John", "Doe", 40)

// Component methods
assertThat(person.component1(), `is`("John"))
assertThat(person.component2(), `is`("Doe"))
assertThat(person.component3(), `is`(40))

// Copy
val anotherPerson = person.copy(surname = "Lennon")
println("${anotherPerson.name} ${anotherPerson.surname} is ${anotherPerson.age} years old")

// Decomposition
val (name, surname, age) = person
println("$name $surname is $age years old")
```


## Creational Patterns

### Factory Method Pattern

The Factory Method Pattern is a design pattern that describes a factory that delivers instances of objects. Instead of calling the constructor of an object, the responsibility will be given to the factory, through a specific method. This means also that the factory methods should not receive parameters that will be used in the creation of the instance of the object. In this way the whole process of creation of the object is encapsulated in the factory and transparent for the class using the factory.

There can be variations of this pattern, for example:
- One method for every object implementation
- A generic method which receives an enum as parameter to distinguish the concrete implementation to be returned.

A generic implementation works as follows:
```kotlin
interface GenericObject

class ConcreteObjectA: GenericObject
class ConcreteObjectB: GenericObject

// Factory implementation with separate methods for concrete implementations
class ObjectFactory {
    // Companion object to call functions statically
    companion object {
        fun createConcreteObjectA(): GenericObject {
            return ConcreteObjectA()
        }
        fun createConcreteObjectB(): GenericObject {
            return ConcreteObjectB()
        }
    }
}

// Usage
val objectA = ObjectFactory.createConcreteObjectA()
```

Pros of Factory Method Pattern:
- Promotes loose coupling: isolates the Object constructor. Imply improved code reuse.
- Promotes Open-Closed Principle: you can extend the Object class and update the existing factory method without modify the code that uses the factory method.
- Improved tests: if an interface is used for the factory there is the possibility to inject a mock factory in testing environment.

Cons of Factory Method Pattern:
- More classes to be created

---
#### 🧩 Exercise 2

1) Modify the method `createTableOrder` in [FactoryMethodExercise](src/main/kotlin/exercises/factory/method/FactoryMethodExercise.kt) to implement `PizzaFactory` with a generic factory method `getPizza` that takes an enumeration as parameter defining the kind of pizza to add to the order and return a corresponding object instance. We want to abstract the use of the enum `Size`.
2) Test the code and verify that the right messages are displayed from the `bake` method.

---

### Abstract Factory Pattern

The Abstract Factory Pattern is a further abstraction of the Factory Method Pattern in which a factory interface is defined and used to implement different factory implementations, each responsible to create specific object implementations.

Here is a simple implementation:

```kotlin
interface GenericObjectA
interface GenericObjectB

class ConcreteObjectA1: GenericObjectA
class ConcreteObjectA2: GenericObjectA

class ConcreteObjectB1: GenericObjectB
class ConcreteObjectB2: GenericObjectB

interface Factory {

    enum class FactoryType {
        ONE, TWO
    }

    fun createObjectA(): GenericObjectA
    fun createObjectB(): GenericObjectB

    // This function could be inside a Provider Object
    companion object {
        fun createFactory(type: FactoryType): Factory {
            return when (type) {
                FactoryType.ONE -> ConcreteFactory1()
                FactoryType.TWO -> ConcreteFactory2()
            }
        }
    }
}

class ConcreteFactory1: Factory {
    override fun createObjectA(): GenericObjectA {
        return ConcreteObjectA1()
    }
    override fun createObjectB(): GenericObjectB {
        return ConcreteObjectB1()
    }
}

class ConcreteFactory2: Factory {
    override fun createObjectA(): GenericObjectA {
        return ConcreteObjectA2()
    }
    override fun createObjectB(): GenericObjectB {
        return ConcreteObjectB2()
    }
}
```

The main functional difference between the Abstract Factory and the Factory Method is that, while the Factory Method Pattern aims at creating single objects instances, the Abstract Factory patterns is suited to create families of objects that are related with each other.

Pros of Abstract Factory:
- Same as Factory Method
- Management of related objects

Cons  of Abstract Factory:
- Same as Factory Method
- Extra work when adding a new Object type in the family of Objects.

---
#### 🧩 Exercise 3

Examine the class [AbstractFactoryExercise](src/main/kotlin/exercises/factory/abstract/AbstractFactoryExercise.kt) and how a game is created.
1) Modify the code of the class [Game](src/main/kotlin/exercises/factory/abstract/Game.kt) to implement an Abstract Factory to create a terrain, vegetation and difficulty.
2) Create a new factory responsible to create a new game with a new terrain, vegetation and difficulty (desert, tundra, ... you decide).
3) Create an enumeration `GameType` that defines the type of game to create. Pass the `GameType` as a parameter to the `playGame` function in [AbstractFactoryExercise](src/main/kotlin/exercises/factory/abstract/AbstractFactoryExercise.kt).
4) Verify that the right message is displayed from the `play` method.

---

### Builder Pattern

The Builder pattern is used to simplify the creation of complex objects by separating the building logic from constructors with a lot of parameters. 
In this case the constructors of the object are private and the object is built using a Builder abstract final class. 
Each Builder method returns the builder itself, allowing to concatenate the methods. 
Finally, the ‘build’ method returns in instance of the object in question.

An advantage of the builder pattern is the to solve the problem of secondary constructors delegation/chaining and the related effort when a new parameter has to be added to the object.

Here a simple implementation:

```kotlin
class Built private constructor() {
    var propA: String = ""
    var propB: Int = 0
    
    class Builder {
        private var built = Built()

        fun propA(value: String): Builder {
            built.propA = value
            return this
        }
        fun propB(value: Int): Builder {
            built.propB = value
            return this
        }
        fun build(): Built {
            return built
        }
    }
}
```

---
#### 🧩 Exercise 4

Create in `main` an instance of the [Cat](src/main/kotlin/exercises/builder/Cat.kt) class using the Builder pattern already implemented. 
1) Which problem do you see in console?
2) Fix the problem so that the console message is display correctly
3) Suppose that weight is not allowed to be negative and name is not allowed to be empty. Implement parameter validation using the `check` function.
4) How would you implement validation if the class constructor was a no-parameters constructor?

---

### Singleton Pattern

The Singleton Pattern is a design pattern that restricts the instantiation of a class to one object. This is useful when exactly one object is needed to coordinate actions across the system.

The generic implementation in Kotlin is with a private constructor and a method in a companion object that returns the instance of the class.

```kotlin
class Singleton private constructor() {
    companion object {
        private var instance: Singleton? = null
        fun getInstance(): Singleton {
            if (instance == null) {
                instance = Singleton()
            }
            return instance!! // !! is the non-null assertion operator
        }
    }
    
    fun doSomething() = println("Do something")
}
```

To make the implementation thread safe, the instance is initialized in a synchronized block, using the double check locking pattern.

```kotlin
class Singleton private constructor() {
    companion object {
        @Volatile
        private var instance: Singleton? = null
        
        fun getInstance(): Singleton {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        instance = Singleton()
                    }
                }
            }
            return instance!!
        }
        
    }

    fun doSomething() = println("Do something")
}
```

The `@Volatile` annotation is used to make the instance variable visible to other threads. This ensures that the instance is updated by one thread and read by other threads atomically.

Pros of Singleton Pattern:
- It does what it is supposed to: a single instance improves performance of the application, reducing the overhead of creating a new instance of the class. Another advantage is that the instance is kept in a consistent and predictable state in the application.

Cons of Singleton Pattern:
- Increased coupling: the client code is tightly coupled with the Singleton class, which makes it difficult to test and maintain the code.

---
#### 🧩 Exercise 5

Modify the function `useCounter` in [SingletonExercise](src/main/kotlin/exercises/singleton/SingletonExercise.kt) to use the Singleton Pattern with double-locking. Test that the method does not throw an exception by calling it from the Main class.

---

### Prototype Pattern

The Prototype Pattern is a design pattern that allows creating new objects by copying existing ones, without having to specify the exact class of the object to be created.
The main advantage of the prototype pattern is that it allows to create new objects with the same characteristics as existing ones, without having to write a new constructor for each class.

Here is a generic implementation of the pattern:
```kotlin
interface Shape {
    fun clone(): Shape
}

class Circle (private val radius: Double = 0.0): Shape {
    override fun clone(): Shape {
        return Circle(radius = radius)
    }
}

class Square (private val side: Double = 0.0): Shape {
    override fun clone(): Shape {
        return Square(side = side)
    }
}
```

The Kotlin Data classes offers the method `copy` out of the box. This method is not a strict implementation of the Prototype pattern because it lacks abstraction. The Prototype should return a clone of the object independently of the type of the object.

To use the Prototype Pattern with Data classes we need to add this abstraction layer.

```kotlin
interface Shape {
    fun clone(): Shape
}

data class Square(private val radius: Double = 0.0): Shape {
    override fun clone(): Shape = copy()
}
```

---
#### 🧩 Exercise 6

Modify the function `createClones` in the class [PrototypeExercise](src/main/kotlin/exercises/prototype/PrototypeExercise.kt) to use the Prototype Pattern with data classes.
For refactoring’s sake, we imply that the methods `cloneCircle` and `cloneSquare` perform the same operations.

---


### Sources
https://kotlinlang.org/docs/classes.html

https://www.programiz.com/kotlin-programming

https://swiderski.tech/series/kotlin-design-patterns/

https://backendhance.com/en/blog/2019/robust-builder-pattern/

https://backendhance.com/blog/2022/bean-validation-antipattern/
