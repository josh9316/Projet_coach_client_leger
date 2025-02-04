<?php
    include_once("vue_insert_exercice.php");
?>

<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

<div class="container mt-5">
    <h3 class="mb-4">Liste des Exercices (<?= count($lesExercices) ?>)</h3>

    <form method="post" class="mb-4">
        <div class="input-group">
            <input type="text" name="filtre" class="form-control" placeholder="Filtrer par nom" aria-label="Filtrer par nom">
            <div class="input-group-append">
                <button class="btn btn-primary" type="submit" name="Filtrer">Filtrer</button>
            </div>
        </div>
    </form>

    <table class="table table-bordered table-striped">
        <thead class="thead-light">
            <tr>
                <th>ID Exo</th>
                <th>Nom de Exo</th>
                <th>Opérations</th>
            </tr>
        </thead>
        <tbody>
            <?php if (isset($lesExercices) && count($lesExercices) > 0): ?>
                <?php foreach ($lesExercices as $unExercice): ?>
                    <tr>
                        <td><?= htmlspecialchars($unExercice['idexercice']) ?></td>
                        <td><?= htmlspecialchars($unExercice['nom']) ?></td>
                        <td>
                            <!-- Lien pour supprimer -->
                            <a href="index.php?page=4&action=sup&idexercice=<?= htmlspecialchars($unExercice['idexercice']) ?>" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cette exo ?')">
                                <img src="images/supprimer.png" height="30" width="30" alt="Supprimer">
                            </a>
                            <!-- Lien pour éditer -->
                            <a href="index.php?page=4&action=edit&idexercice=<?= htmlspecialchars($unExercice['idexercice']) ?>">
                                <img src="images/editer.png" height="30" width="30" alt="Éditer">
                            </a>
                        </td>
                    </tr>
                <?php endforeach; ?>
            <?php else: ?>
                <tr>
                    <td colspan="3" class="text-center">Aucun Exercices trouvé.</td>
                </tr>
            <?php endif; ?>
        </tbody>
    </table>
    <br><br><br>
</div>