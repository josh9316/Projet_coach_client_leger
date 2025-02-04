<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

<style>
    .form-container {
        background-color: white; /* White background for the form */
        border-radius: 8px; /* Rounded corners */
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Subtle shadow */
        padding: 2rem; /* Padding around the form */
    }
    .form-label {
        font-weight: bold; /* Bold labels for better visibility */
    }
    .btn-custom {
        background-color: #007bff; /* Custom button color */
        color: white; /* White text on buttons */
    }
    .btn-custom:hover {
        background-color: #0056b3; /* Darker shade on hover */
    }
    
</style>


<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

<div class="container mt-5">
    <h3 class="mb-4">Ajout d'un Club sportif</h3>

    <form method="post">
        <div class="form-group">
            <label for="nom">Nom du Club</label>
            <input type="text" class="form-control" id="nom" name="nom" value="<?= ($leClub != null) ? htmlspecialchars($leClub['nom']) : '' ?>" required>
        </div>
        <div class="form-group">
            <label for="prenom">Prénom & Nom du Président</label>
            <input type="text" class="form-control" id="prenom" name="prenom" value="<?= ($leClub != null) ? htmlspecialchars($leClub['prenom']) : '' ?>" required>
        </div>
        <div class="form-group">
            <label for="adresse">Adresse postale</label>
            <input type="text" class="form-control" id="adresse" name="adresse" value="<?= ($leClub != null) ? htmlspecialchars($leClub['adresse']) : '' ?>" required>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" value="<?= ($leClub != null) ? htmlspecialchars($leClub['email']) : '' ?>" required>
        </div>
        <div class="form-group">
            <label for="tel">Téléphone</label>
            <input type="tel" class="form-control" id="tel" name="tel" value="<?= ($leClub != null) ? htmlspecialchars($leClub['tel']) : '' ?>" required>
        </div>
        <div class="form-group">
            <label for="date_naissance">Date de création du Club</label>
            <input type="date" class="form-control" id="date_naissance" name="date_naissance" value="<?= ($leClub != null) ? htmlspecialchars($leClub['date_naissance']) : '' ?>" required>
        </div>
        <div class="d-flex justify-content-between">
            <button type="reset" class="btn btn-secondary">Annuler</button>
            <button type="submit" class="btn btn-primary" name="<?= ($leClub != null) ? 'Modifier' : 'Valider' ?>">
                <?= ($leClub != null) ? 'Modifier' : 'Valider' ?>
            </button>
        </div>
        <!-- Si $leClub est défini, on ajoute un champ caché pour l'ID -->
        <?= ($leClub != null) ? '<input type="hidden" name="idclub" value="' . htmlspecialchars($leClub['idclub']) . '">' : '' ?>
    </form>
</div>
