import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "3.2.2"
  id("io.spring.dependency-management") version "1.1.4"
  kotlin("jvm") version "1.9.22"
  kotlin("plugin.spring") version "1.9.22"
  kotlin("pl" +
    "ugin.jpa") version "1.9.22"
}

group = "com.ropa-formal"
version = "0.0.1"

java {
  sourceCompatibility = JavaVersion.VERSION_21
}

configurations {
  compileOnly {
    extendsFrom(configurations.annotationProcessor.get())
  }
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  compileOnly("org.projectlombok:lombok")
  runtimeOnly("org.postgresql:postgresql")
  annotationProcessor("org.projectlombok:lombok")
  testImplementation("org.springframework.boot:spring-boot-starter-test")

  //libreria para Sawgger
  implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")

  //libreria de spring security
  implementation("org.springframework.boot:spring-boot-starter-security")

  //liberia para JWT
  implementation ("com.auth0:java-jwt:4.4.0")

  // https://mvnrepository.com/artifact/org.mapstruct/mapstruct
  implementation("org.mapstruct:mapstruct:1.5.5.Final")

}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs += "-Xjsr305=strict"
    jvmTarget = "21"
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}
