# 📖 **Documentació de l'app PokeShop**

🌟 **Benvingut/da a PokeShop!** 🌟  
PokeShop és una app Android feta amb **Kotlin** que et permet gestionar una botiga Pokémon 🛒. És fàcil d'utilitzar, visualment atractiva i ideal per als fans de Pokémon. Let's go! 🚀

---

## 🧐 **Què és PokeShop?**  
PokeShop és una aplicació mòbil que et permet:  
- 📋 Veure el catàleg de productes Pokémon.  
- 🛍️ Afegir productes al carret de la compra.  
- 🗑️ Eliminar productes del carret.  
- 💳 Finalitzar la compra.  
Tot això amb una interfície d'usuari senzilla i amigable! 😊  

---

## 🚀 **Com començar?**

### 1️⃣ **Requisits previs**  
Abans de començar, assegura’t de tenir:  
- 🛠️ Android Studio instal·lat.  
- 📱 Un dispositiu Android o un emulador configurat.  
- 🔥 Coneixements bàsics de Kotlin i Android.  

### 2️⃣ **Clona el repositori**  
Clona el projecte al teu ordinador:  
```bash
git clone https://github.com/Bepo04/m07_PokeShop.git
3️⃣ Obre el projecte a Android Studio

    Obre Android Studio.
    Fes clic a File > Open i selecciona la carpeta del projecte.
    Espera que Gradle faci la sincronització automàtica. 🛠️

🛠️ Com està estructurat el projecte?

L'app està dividida en diversos components principals:

📂 Estructura de carpetes

    app/src/main/java/com/pokeshop/
        models: Conté les classes que defineixen els productes i altres dades.
        views: Conté les activitats i fragments (interfície d'usuari).
        adapters: Gestiona les llistes, com el RecyclerView per als productes.
        controllers: Conté la lògica principal de l'aplicació.
        utils: Funcions auxiliars i constants.

📑 Fitxers principals

    MainActivity.kt: La porta d'entrada a l'aplicació.
    ProductListFragment.kt: Mostra el catàleg de productes.
    CartFragment.kt: Gestiona els productes del carret de la compra.
    CheckoutActivity.kt: Finalitza la compra.

🕹️ Com executar l'app?

    Connecta un dispositiu Android al teu ordinador o inicia un emulador.
    A Android Studio, fes clic al botó ▶️ (Run).
    Selecciona el dispositiu o emulador i espera que l'app es compili i s'executi.

✨ Funcionalitats principals
🛒 Catàleg de productes

    Mostra una llista amb els productes Pokémon disponibles.
    Cada producte té una imatge, nom, descripció i preu.

➕ Afegir al carret

    Un botó permet afegir els productes al carret de la compra.

🗑️ Eliminar del carret

    Pots eliminar productes directament des del carret.

✅ Finalitzar compra

    Mostra el total i finalitza la compra amb un simple clic.

🤝 Col·laboració

Tens idees per millorar PokeShop? Ens encantarà veure-les! 😍

    Fes un fork del projecte 🍴
    Crea una nova branca:

git checkout -b feature/la-teva-idea

Fes els canvis i puja’ls:

    git add .  
    git commit -m "Afegeix la teva idea 💡"  
    git push origin feature/la-teva-idea  

    Obre un Pull Request i revisarem el teu treball!

🐞 Reporta errors

Si trobes algun error, no dubtis a obrir una Issue al repositori. Explica què ha passat i t’ajudarem tan aviat com puguem! 🚑
