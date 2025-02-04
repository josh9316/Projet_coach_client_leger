<?php
if (isset($_SESSION['successMessage'])) {
    echo '<p class="alert alert-success">' . $_SESSION['successMessage'] . '</p>';
    unset($_SESSION['successMessage']);
}

if (isset($_SESSION['errorMessage'])) {
    echo '<p class="alert alert-danger">' . $_SESSION['errorMessage'] . '</p>';
    unset($_SESSION['errorMessage']);
}
?>

<div class="container mt-5">
    <h3 class="mb-4">Ajouter un Exercice</h3>
    <form method="post">
        <div class="form-group">
            <label>Nom de l'exercice</label>
            <input type="text" name="nom" class="form-control" required value="<?= ($leExercice) ? htmlspecialchars($leExercice['nom']) : '' ?>">
        </div>
        <div class="form-group">
            <label>Description</label>
            <textarea name="description" class="form-control" required><?= ($leExercice) ? htmlspecialchars($leExercice['description']) : '' ?></textarea>
        </div>
        <div class="form-group">
            <label>Durée (minutes)</label>
            <input type="number" name="duree" class="form-control" required value="<?= ($leExercice) ? htmlspecialchars($leExercice['duree']) : '' ?>">
        </div>
        <button type="submit" class="btn btn-primary" name="<?= ($leExercice) ? 'Modifier' : 'Valider' ?>">
            <?= ($leExercice) ? 'Modifier' : 'Valider' ?>
        </button>
        <?= ($leExercice) ? '<input type="hidden" name="idexercice" value="' . htmlspecialchars($leExercice['idexercice']) . '">' : '' ?>
    </form>
</div>
    