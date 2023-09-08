plugins {
    id("java")
    id("application")
}

application {
    mainClass.set("com.open592.jarsigner.Main")

    applicationDefaultJvmArgs = listOf(
        "--add-opens=java.base/jdk.internal.access=ALL-UNNAMED",
        "--add-opens=java.base/sun.security.pkcs=ALL-UNNAMED",
        "--add-opens=java.base/sun.security.tools=ALL-UNNAMED",
        "--add-opens=java.base/sun.security.util=ALL-UNNAMED",
        "--add-opens=java.base/sun.security.x509=ALL-UNNAMED",
        "--add-opens=java.base/sun.security.validator=ALL-UNNAMED",
        )
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.withType<JavaCompile> {
    val compilerArgs = options.compilerArgs

    compilerArgs.add("--add-exports=java.base/jdk.internal.access=ALL-UNNAMED")
    compilerArgs.add("--add-exports=java.base/sun.security.pkcs=ALL-UNNAMED")
    compilerArgs.add("--add-exports=java.base/sun.security.timestamp=ALL-UNNAMED")
    compilerArgs.add("--add-exports=java.base/sun.security.tools=ALL-UNNAMED")
    compilerArgs.add("--add-exports=java.base/sun.security.validator=ALL-UNNAMED")
    compilerArgs.add("--add-exports=java.base/sun.security.x509=ALL-UNNAMED")
    compilerArgs.add("--add-exports=java.base/sun.security.util=ALL-UNNAMED")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

tasks.test {
    useJUnitPlatform()
}