# 🚀 Microservicios con Spring Boot & Spring Cloud

Proyecto de exploración de arquitectura de microservicios utilizando **Spring Boot** y **Spring Cloud**, implementando componentes clave como Discovery Server (Eureka), Config Server, API Gateway y Circuit Breaker para lograr comunicación eficiente, configuración centralizada y resiliencia entre servicios.

---

## 📌 Tecnologías

- Java
- Spring Boot
- Spring Cloud
- Eureka (Service Discovery)
- Spring Cloud Config
- Spring Cloud Gateway
- Resilience4j
- Maven / Gradle

---

## 🧩 Arquitectura

El proyecto incluye los siguientes componentes:

- **Config Server** → Configuración centralizada
- **Discovery Server (Eureka)** → Registro y descubrimiento de servicios
- **API Gateway** → Punto de entrada único
- **Microservicios** → Servicios independientes
- **Circuit Breaker** → Manejo de fallos y resiliencia

---

## 🔄 Flujo

1. El Config Server provee configuración a los servicios
2. Los servicios se registran en Eureka
3. El cliente consume a través del API Gateway
4. El Gateway enruta hacia el microservicio correspondiente
5. El Circuit Breaker actúa ante fallos

---

## ⚙️ Ejecución

### Clonar repositorio
```bash
git clone https://github.com/tu-usuario/tu-repo.git
cd tu-repo