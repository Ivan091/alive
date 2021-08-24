plugins {
    application
    id("org.openjfx.javafxplugin") version "0.0.10"
}

javafx {
    modules("javafx.controls", "javafx.fxml")
}

application {
    mainClass.set("alive.JavaFxApplication")
}

dependencies {
    implementation(project(":model"))
    implementation("org.springframework.boot:spring-boot-autoconfigure")
}