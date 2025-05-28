<h3>Ajout d'un coach</h3>

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

<div class="container mt-5">
    <div class="form-container">
        <h2 class="mb-4 text-center"><?= ($leCoach != null) ? 'Modifier Coach' : 'Ajouter Coach' ?></h2>
        <form method="post">
            <div class="form-group">
                <label for="nom" class="form-label">Nom Coach</label>
                <input type="text" class="form-control" id="nom" name="nom" value="<?= ($leCoach != null) ? htmlspecialchars($leCoach['nom']) : '' ?>" required>
            </div>
            <div class="form-group">
                <label for="prenom" class="form-label">Prénom du Coach</label>
                <input type="text" class="form-control" id="prenom" name="prenom" value="<?= ($leCoach != null) ? htmlspecialchars($leCoach['prenom']) : '' ?>" required>
            </div>
            <div class="form-group">
                <label for="specialite" class="form-label">Spécialité</label>
                <input type="text" class="form-control" id="specialite" name="specialite" value="<?= ($leCoach != null) ? htmlspecialchars($leCoach['specialite']) : '' ?>" required>
            </div>
            <div class="form-group">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" value="<?= ($leCoach != null) ? htmlspecialchars($leCoach['email']) : '' ?>" required>
            </div>
            <div class="form-group">
                <label for="tel" class="form-label">Téléphone</label>
                <input type="tel" class="form-control" id="tel" name="tel" value="<?= ($leCoach != null) ? htmlspecialchars($leCoach['tel']) : '' ?>" required>
            </div>

            <!-- 📌 Ajout du menu déroulant pour le sexe -->
            <div class="form-group">
                <label for="sexe" class="form-label">Sexe</label>
                <select class="form-control" id="sexe" name="sexe" required>
                    <option value="" disabled selected>Choisir le sexe</option>
                    <option value="homme" <?= ($leCoach != null && $leCoach['sexe'] == 'homme') ? 'selected' : '' ?>>Homme</option>
                    <option value="femme" <?= ($leCoach != null && $leCoach['sexe'] == 'femme') ? 'selected' : '' ?>>Femme</option>
                </select>
            </div>
            <!-- 📌 Fin du menu déroulant -->

            <div class="d-flex justify-content-between">
                <button type="reset" class="btn btn-secondary">Annuler</button>
                <button type="submit" class="btn btn-custom" name="<?= ($leCoach != null) ? 'Modifier' : 'Valider' ?>">
                    <?= ($leCoach != null) ? 'Modifier' : 'Valider' ?>
                </button>
            </div>
            <?= ($leCoach != null) ? '<input type="hidden" name="idcoach" value="'.htmlspecialchars($leCoach['idcoachs']).'">' : '' ?>
        </form>
    </div>
</div>
