# Cara SEGRETAIN LEFEBVRE

La totalité du projet est fonctionnelle d'après les demandes du cahier des charges du TP.

Utilisation : 

Une page "welcome" a été faite et contiens l'ensemble des liens vers les fonctions de l'application. Nous avons décidé de ne pas filtrer ces liens selon l'utilisateur 
Pour que vous puissiez vérifier simplement que les droits d'accès sont contrôlé coté serveur.


- Assuré:
    - Une assuré a accès à une page ou il peut à la fois consulter ses contrats en cours, voir l'état des demandes en attente qu'il possède (Un webSocket est présent sur cette page)
    Lorsque le courtier valide la suppression d'un contrat en demande de suppression un message apparait sur la page coté Assuré, il peut le faire disparaitre en cliquant dessus.
    
- Courtier:
    - Un courtier peut saisir un contrat dans l'outil directement (on peut imaginer que le client soit présent physiquement en agence et que le courtier saisisse le dossier sans que le client le demande via l'outil)
    Il peut également accéder à la liste des clients qu'il suit. Pour chacun de ses clients il peut visualiser les contrat en cours et en attente. Il peut à partir de cette page valider les demandes de ses clients.
    Le Courtier a également accès à une page qui résume les contrats qui attendent une action de sa part et il peut directement valider ou supprimer ceux-ci.
    
- Admin:
    - L'administrateur a les droits sur les CRUD de l'outil. Il peut gérer les utilisateurs et les types de contrats.
    
   

Des rôles ont étés définis et ils sont également fonctionnels. Des captures de la configuration de notre glassfish sont jointes au projet afin que vous puissiez vérifier que notre configuration est bonne.
Nous avons choisi de ne pas donner tous les accès à l'administrateur car il n'est pas logique que ce dernier puisse effectuer des actions métier.

- Choix sur les interfaces : Nous avons choisi de faire des interfaces basiques car le but de ce TP n'est pas de montrer que nous savons taper du HTML,
mais bien que nous savons utiliser les composants EJB entre autres. C'est pourquoi nous avons également décidé de regrouper certaine vues en une (création d'un contrat par exemple) au lieu de faire une vue par type de contrat.

- Roles des utilisateurs : Nous avons choisi de placer les rôles des utilisateurs non pas dans une tables externe (afin de pouvoir mettre plusieurs rôles à un User) mais
au sein même de la table User via le champ DTYPE_USER qui correspond au type de user.

