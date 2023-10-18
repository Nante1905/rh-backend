```json
{
  "debut": "2023-10-17",
  "fin": "2023-10-18",
  "idJob": 1,
  "idTypeContrat": 1,
  "salaireBrute": 1234,
  "categorie": {
    "id": 1
  }
  "avantages": [
    {
      "id": 1
    },
    {
      "id": 2
    }
  ]
}
```

```json
{
  "nom": "Rakoto",
  "prenom": "Jean",
  "naissance": "2003-12-05",
  "email": "jean@gmail.com",
  "telephone": "0320012345",
  "mdp": "Jean",
  "ville": {
    "id": 1
  }
}
```

DATA POUR CREER CV

```json
{
  "nom": "Mireille_cv_1",
  "utilisateur": { "id": 1 },
  "diplome": { "diplome": { "id": 2 } },
  "domaine": { "domaine": { "id": 1 } },
  "matrimonial": { "matrimonial": { "id": 1 } },
  "experience": { "experience": { "id": 1 } }
}
```

j'ai une table test_reponse(id_test, id_question, id_reponse, valeurcandidat) telle que
-id_test a une relation n:1 avec table test
-id_question a une relation n:1 avec la table question (contenu
-id_reponse a une relation n:1 avec table reponse (contenu, valeur)
une question a plusieurs réponses c-a-d on a une répétitiond e id-question et id_test pour des id_reponse différents

J'utilise spring boot. Aide moi à former mes classes de telle sortes que lorsque je donne un id_test j'ai un truc du genre
{ [
question: {
contenu: 'question',
reponses: [
{
rep: {
contenu: 'reponse',
valeur: boolean ,
},
valeurCandidat: boolean
},
{
rep: {
contenu: 'reponse',
valeur: boolean ,
},
valeurCandidat: boolean
}]
