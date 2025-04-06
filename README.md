# 📖 **Documentació de l'app PokeShop**

## Novetats Pràctica 6.3
En aquesta actualització, hem incorporat diverses funcionalitats noves per millorar l'experiència de l'usuari:
Generació d'estadístiques del carret de la compra: Ara, l'aplicació pot generar estadístiques basades en els productes que tens al carret, proporcionant informació detallada sobre les teves compres.​
Ús de localStorage per a la persistència de dades: Hem implementat l'ús de localStorage per emmagatzemar les dades del carret de la compra, assegurant que la informació es persisteix.

## Novetats Pràctica 6.2
A part del requisit mínim d'editar dades a través d'endpoints de la API, hem desenvolupat una búsqueda per text. Hem fet un endpoint que fa una consulta amb una condició semblant a l'operador _LIKE_ de SQL, de manera que si introduim un text a la barra de búsqueda de l'activity de productes, carregarem una llista amb tots els Pokemon que continguin el text en el seu nom.

---

# 📱 PokeShop

PokeShop és una aplicació mòbil per a Android que simula una botiga de productes Pokémon. L'objectiu principal és permetre a l'usuari consultar productes, afegir-los al carret de la compra, gestionar-los i consultar estadístiques de compra. Està desenvolupada amb **Kotlin**, fa ús d'una **API REST** i utilitza **localStorage** per persistència local.

---

## 🚀 Funcionalitats Principals

- 🛍️ **Visualització de productes**  
  Consulta el catàleg de productes Pokémon disponibles a la botiga.

- ➕ **Afegir al carret**  
  Afegeix productes al carret amb un sol clic.

- ❌ **Eliminar del carret**  
  Treu productes del carret quan ja no els necessitis.

- 🧾 **Finalitzar compra**  
  Simula una compra dels productes seleccionats.

- 🔍 **Cerca per nom**  
  Utilitza una barra de cerca per trobar productes pel nom (implementació tipus `LIKE` en SQL via endpoint).

- 📊 **Estadístiques del carret**  
  Nova funcionalitat! Es generen estadístiques dels productes afegits al carret com:
  - Quantitat total de productes
  - Total acumulat en € 
  - Nombre de productes per tipus
  - Gràfiques i visualització de dades (si aplica)

- 💾 **Persistència amb localStorage**  
  Les dades del carret es guarden en localStorage, permetent que l’usuari no perdi la seva selecció encara que tanqui l’app.

---

## 🛠️ Tecnologies Utilitzades

- **Kotlin** – Llenguatge principal per al desenvolupament Android
- **Android Studio** – IDE utilitzat
- **API RESTful** – Per a la gestió de dades i consultes
- **localStorage (SharedPreferences)** – Emmagatzematge local persistent

---

## 📥 Instal·lació

1. Clona el repositori:

   ```bash
   git clone https://github.com/Bepo04/m07_PokeShop.git
   ```

2. Obre el projecte a Android Studio:
   - `File > Open`
   - Selecciona la carpeta `m07_PokeShop`

3. Compila i executa:
   - Connecta un dispositiu Android o utilitza un emulador
   - Prem el botó ▶️ "Run"

---

## 📂 Estructura del Projecte

```
app/
├── src/
│   └── main/
│       ├── java/com/pokeshop/
│       │   ├── activities/
│       │   ├── adapters/
│       │   ├── api/
│       │   ├── models/
│       │   └── utils/
│       └── res/
│           ├── layout/
│           └── values/
```
---

## 📄 Llicència

Aquest projecte està llicenciat sota la **MIT License**. Consulta el fitxer `LICENSE` per a més informació.

---

## 👥 Autors

Projecte desenvolupat per Eric Ayxendri & Pau Lorca :)
