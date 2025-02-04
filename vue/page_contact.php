<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cabinet BASKET_MVC</title>
    <style>
        /* Styles généraux */
        body {
            font-family: 'Montserrat', sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
            text-align: center;
        }

        /* Barre de navigation */
        nav {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #ffffff;
            padding: 15px 30px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .site-title {
            font-size: 1.5em;
            font-weight: bold;
            color: #333;
        }

        .nav-links {
            display: flex;
            gap: 20px;
        }

        .nav-links a {
            text-decoration: none;
            color: #333;
            font-size: 1.2em;
            font-weight: bold;
            padding: 10px 15px;
            transition: background 0.3s;
            border-radius: 5px;
        }

        .nav-links a:hover {
            background-color: rgba(0, 0, 0, 0.1);
        }

        /* Conteneur principal */
        section {
            padding: 20px;
            max-width: 1200px;
            margin: auto;
            background-color: white;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        /* Formulaire de contact */
        .contact-form {
            max-width: 600px;
            margin: 40px auto;
            padding: 20px;
            background: white;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        .contact-form input,
        .contact-form textarea {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .contact-form button {
            background-color: #007bff;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1.2em;
        }

        .contact-form button:hover {
            background-color: #0056b3;
        }

        /* Pied de page */
        footer {
            background-color: #343a40;
            color: white;
            padding: 15px 0;
            margin-top: 40px;
            font-size: 1.1em;
        }
    </style>
</head>
<body>
    
    <section>
        <div class="contact-form">
            <h2>Contactez-nous</h2>
            <form>
                <input type="text" placeholder="Votre nom" required>
                <input type="email" placeholder="Votre email" required>
                <textarea placeholder="Votre message" rows="5" required></textarea>
                <button type="submit">Envoyer</button>
            </form>
        </div>
    </section>

    <footer>
        <p>&copy; 2025 - Tous droits réservés</p>
    </footer>
</body>
</html>