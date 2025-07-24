## 📡 API Endpoints

У цьому проєкті реалізовано три основні контролери:

---

### 1. 🏃‍♂️ PlayerController — CRUD для гравців

**Базовий шлях:** `/api/player`

| HTTP  | Шлях    | Опис                                    | Запит                                  | Відповідь                   |
|-------|---------|-----------------------------------------|----------------------------------------|-----------------------------|
| GET   | `/{id}` | Повернути гравця за `id`                | —                                      | `PlayerDTO`                 |
| GET   | `/all`  | Повернути список всіх гравців           | —                                      | `List<PlayerDTO>`           |
| POST  | `/`     | Створити нового гравця                  | `CreatePlayerDTO`                      | `201 Created` / помилка     |
| PATCH | `/`     | Оновити існуючого гравця                | `UpdatePlayerDTO`                      | `200 OK` / помилка          |
| DELETE| `/{id}` | Видалити гравця за `id`                 | —                                      | `200 OK` / помилка          |

**DTO:**
- `CreatePlayerDTO(name: String, birthDate: String, experienceMonths: Integer, teamId: Integer)`
- `UpdatePlayerDTO(id: Integer, name?: String, birthDate?: String, experienceMonths?: Integer, teamId?: Integer)`

---

### 2. 🏟️ TeamController — CRUD для команд

**Базовий шлях:** `/api/team`

| HTTP  | Шлях    | Опис                                    | Запит                                  | Відповідь                   |
|-------|---------|-----------------------------------------|----------------------------------------|-----------------------------|
| GET   | `/{id}` | Повернути команду за `id`               | —                                      | `TeamDTO`                   |
| GET   | `/all`  | Повернути список всіх команд            | —                                      | `List<TeamDTO>`             |
| POST  | `/`     | Створити нову команду                   | `CreateTeamDTO`                        | `201 Created` / помилка     |
| PATCH | `/`     | Оновити інформацію про команду          | `UpdateTeamDTO`                        | `200 OK` / помилка          |
| DELETE| `/{id}` | Видалити команду за `id`                | —                                      | `200 OK` / помилка          |

**DTO:**
- `CreateTeamDTO(name: String, city: String, foundationYear: Integer)`
- `UpdateTeamDTO(id: Integer, name?: String, city?: String, foundationYear?: Integer)`

---a

### 3. 🔄 TransferController — логіка трансферів між командами

**Базовий шлях:** `/api/transfer`

| HTTP | Шлях             | Опис                                      | Запит                    | Відповідь               |
|------|------------------|-------------------------------------------|--------------------------|-------------------------|
| POST | `/api/transfer`  | Перевести гравця з однієї команди в іншу   | `NewTransferDTO`         | `200 OK` / помилка      |

**DTO:**
- `NewTransferDTO(playerId: Integer, toTeamId: Integer)`

Уся бізнес-логіка трансферу (зміна команди, розрахунок комісії, оновлення балансу) інкапсульована у `TransferService`.

---

## 📂 Файл бази даних

- **`footballdb.sql`**  
  Містить DDL для створення таблиць та наповнення тестовими даними:
    - Таблиці `players`, `teams`, `transfers`
    - Первинні ключі, зовнішні ключі, індекси
    - Приклади записів команд і гравців
