<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">



<div class="container mt-5">
    <h2 class="mb-4">Insertion d'un Rendez-vous</h2>

    <form method="post">
        <div class="form-group">
            <label for="idclub">Club</label>
            <select name="idclub" id="idclub" class="form-control" required>
                <option value="">Sélectionner un idclub</option>
                <?php foreach ($lesClubs as $club): ?>
                    <option value="<?= htmlspecialchars($club['idclub']) ?>"><?= htmlspecialchars($club['nom']) ?></option>
                <?php endforeach; ?>
            </select>
        </div>

        <div class="form-group">
            <label for="idcoach">Coach</label>
            <select name="idcoach" id="idcoach" class="form-control" required>
                <option value="">Sélectionner un coach</option>
                <?php foreach ($lesCoachs as $coach): ?>
                    <option value="<?= htmlspecialchars($coach['idcoach']) ?>"><?= htmlspecialchars($coach['nom']) ?></option>
                <?php endforeach; ?>
            </select>
        </div>

        <div class="form-group">
            <label for="idexercice">Exercice</label>
            <select name="idexercice" id="idexercice" class="form-control" required>
                <option value="">Sélectionner un exercice</option>
                <?php foreach ($lesExercices as $exercice): ?>
                    <option value="<?= htmlspecialchars($exercice['idexercice']) ?>"><?= htmlspecialchars($exercice['nom']) ?></option>
                <?php endforeach; ?>
            </select>
        </div>

        <div class="form-group">
            <label for="dateRendezVous">Date du rendez-vous</label>
            <input type="datetime-local" name="dateRendezVous" id="dateRendezVous" class="form-control" required>
        </div>

        <div class="form-group">
            <label for="motif">Motif</label>
            <textarea name="motif" id="motif" class="form-control" rows="4" required></textarea>
        </div>

        <div class="d-flex justify-content-between">
            <button type="reset" class="btn btn-secondary">Annuler</button>
            <button type="submit" class="btn btn-primary" name="Valider">Valider</button>
        </div>
    </form>
</div>