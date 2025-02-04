<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

<div class="container mt-5">
    <h3 class="mb-4">Liste des Rendez-vous</h3>

    <form method="post" class="mb-4">
        <div class="input-group">
            <input type="text" name="filtre" id="filtre" class="form-control" placeholder="Filtrer par nom, motif, etc." value="<?= isset($_POST['filtre']) ? htmlspecialchars($_POST['filtre']) : '' ?>">
            <div class="input-group-append">
                <button class="btn btn-primary" type="submit" name="Filtrer">Filtrer</button>
            </div>
        </div>
    </form>

    <table class="table table-bordered table-striped">
        <thead class="thead-light">
            <tr>
                <th>ID RDV</th>
                <th>Date du rendez-vous</th>
                <th>Motif</th>
                <th>Club</th>
                <th>Coachs</th>
                <th>Exercice</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <?php foreach ($lesRDVs as $rdv): ?>
                <tr>
                    <td><?= htmlspecialchars($rdv['idrendezvous']) ?></td>
                    <td><?= htmlspecialchars($rdv['dateRendezVous']) ?></td>
                    <td><textarea class="form-control" rows="4" readonly><?= htmlspecialchars($rdv['motif']) ?></textarea></td>
                    <td><?= htmlspecialchars($rdv['idclub']) ?></td>
                    <td><?= htmlspecialchars($rdv['idcoach']) ?></td>
                    <td><?= htmlspecialchars($rdv['idexercice']) ?></td>
                    <td>
                        <a href="index.php?page=5&action=edit&idrendezvous=<?= htmlspecialchars($rdv['idrendezvous']) ?>" class="btn btn-warning btn-sm">Modifier</a>
                        <a href="index.php?page=5&action=sup&idrendezvous=<?= htmlspecialchars($rdv['idrendezvous']) ?>" class="btn btn-danger btn-sm" onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce RDV ?')">Supprimer</a>
                    </td>
                </tr>
            <?php endforeach; ?>
        </tbody>
    </table>
    <br><br><br>

    <?php if (isset($message)): ?>
        <div class="alert alert-info"><?= htmlspecialchars($message) ?></div>
    <?php endif; ?>
</div>