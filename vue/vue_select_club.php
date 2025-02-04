<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

<div class="container mt-5">
    <h3 class="mb-4">Liste des Clubs (<?= count($lesClubs) ?>)</h3>

    <form method="post" class="mb-4">
        <div class="input-group">
            <input type="text" name="filtre" class="form-control" placeholder="Filtrer par..." aria-label="Filtrer par">
            <div class="input-group-append">
                <button class="btn btn-primary" type="submit" name="Filtrer">Filtrer</button>
            </div>
        </div>
    </form>

    <table class="table table-bordered table-striped">
        <thead class="thead-light">
            <tr>
                <th>Id Club</th>
                <th>Nom Club</th>
                <th>Prénom</th>
                <th>Adresse Postale</th>
                <th>Email</th>
                <th>Téléphone</th>
                <th>Date de creation</th>
                <th>Opération</th>
            </tr>
        </thead>
        <tbody>
            <?php
            if (isset($lesClubs)) {
                foreach ($lesClubs as $unClub) {
                    echo "<tr>";
                    echo "<td>" . htmlspecialchars($unClub['idclub']) . "</td>";
                    echo "<td>" . htmlspecialchars($unClub['nom']) . "</td>";
                    echo "<td>" . htmlspecialchars($unClub['prenom']) . "</td>";
                    echo "<td>" . htmlspecialchars($unClub['adresse']) . "</td>";
                    echo "<td>" . htmlspecialchars($unClub['email']) . "</td>";
                    echo "<td>" . htmlspecialchars($unClub['tel']) . "</td>";
                    echo "<td>" . htmlspecialchars($unClub['date_naissance']) . "</td>";
                    echo "<td>";
                    echo "<a href='index.php?page=2&action=sup&idclub=" . htmlspecialchars($unClub['idclub']) . "'><img src='images/supprimer.png' height='30' width='30' alt='Supprimer'></a>";
                    echo "<a href='index.php?page=2&action=edit&idclub=" . htmlspecialchars($unClub['idclub']) . "'><img src='images/editer.png' height='30' width='30' alt='Modifier'></a>";
                    echo "</td>";
                    echo "</tr>";
                }
            }
            ?>
        </tbody>
    </table>
    <br><br><br>
</div>