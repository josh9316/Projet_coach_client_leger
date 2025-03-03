<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Connexion</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
    <div class="login-container">
        <div class="illustration">
            <img src="images/connexion_coach.png" alt="Illustration">
        </div>
        <div class="login-form">
            <h2>Bienvenue sur le Terrain</h2>
            <form method="post">
                <div class="input-group">
                    <label for="email">Email</label>
                    <input type="text" name="email" id="email" placeholder="Entrez votre email">
                </div>
                <div class="input-group password-group">
                    <label for="mdp">Mot de passe</label>
                    <input type="password" name="mdp" id="mdp" placeholder="Entrez votre mot de passe">
                </div>
                <button type="submit" name="Connexion">Connexion</button>
                <div class="signup">
    <p>Pas encore de compte ? <a href="Controller/InscriptionController.php">Inscrivez-vous ici</a></p>
</div>

            </form>
        </div>
    </div>
</body>
</html>
<style>
    /* Styles généraux */
body {
    font-family: 'Arial', sans-serif;
    background-color: #f4f4f4;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
}

/* Conteneur principal */
.login-container {
    display: flex;
    background: white;
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
    border-radius: 10px;
    overflow: hidden;
    width: 800px;
    max-width: 90%;
}



.illustration {
    background: linear-gradient(135deg, #6a11cb, #2575fc);    display: flex;
    justify-content: center;
    align-items: center;
    padding: 30px;
    flex: 1;
}

.illustration img {
    max-width: 100%;
    width: 100px;
    height: auto;
}

.login-form {
    flex: 1;
    padding: 40px;
    text-align: center;
    height:350px;   
}

h2 {
    margin-bottom: 20px;
    font-size: 24px;
    color: #333;
}

.input-group {
    text-align: left;
    margin-bottom: 15px;
}

.input-group label {
    display: block;
    font-weight: bold;
    margin-bottom: 5px;
}

.input-group input {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 16px;
}

.password-group {
    position: relative;
}

.toggle-password {
    position: absolute;
    right: 10px;
}

.options {
    display: flex;
    justify-content: space-between;
    font-size: 14px;
    margin-bottom: 20px;
}

button {
    width: 100%;
    padding: 10px;
    background-color: #333;
    color: white;
    border: none;
    border-radius: 5px;
    font-size: 16px;
    cursor: pointer;
    transition: 0.3s;
}

button:hover {
    background-color: #555;
}

.google-login {
    margin-top: 10px;
    background-color: #fff;
    color: #333;
    border: 1px solid #ccc;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 14px;
}

.google-login:hover {
    background-color: #f0f0f0;
}

.error-message {
    color: red;
    margin-top: 10px;
}

.signup {
    margin-top: 20px;
    font-size: 14px;
}

.signup a {
    color: #007bff;
    text-decoration: none;
}

.signup a:hover {
    text-decoration: underline;
}

</style>