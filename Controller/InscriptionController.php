<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>inscription</title>
    <style> 
    input{
        margin-bottom: 10px;
    }
    </style>
</head>
<body>
    <form method="POST" action="traitement.php"> 
<label for="nom">Votre nom*</label>
<input type="text" id="nom" name="nom" placeholder="Entrée votre nom..."required>
</br>
<label for="prénom">Votre prénom*</label>
<input type="text" id="prenom" name="prenom" placeholder="Entrée votre prénom..."required>
</br>
<label for="email">Votre email*</label>
<input type="text" id="email" name="email" placeholder="Entrée votre email..."required>
</br>
<label for="mot de passe">Votre mot de passe*</label>
<input type="text" id="mot de passe" name="mot de passe" placeholder="Entrée votre mot de passe..."required>
</br>
<input type="submit" value="M'inscrire" name="ok"> 
</form>


</body>
</html>