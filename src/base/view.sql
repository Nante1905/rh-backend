create view v_info_job as  select j.id, j.title, j.jour, s.nom_service as service from job j join service s on j.idservice=s.id;

-- MODULE TEST
create or replace view v_reponse_candidat  as select t_r.id_test, t_r.id_question, t_r.id_reponse , r.contenu, t_r.valeur as r_candidat, r.valeur as r_vrai, case when(t_r.valeur = r.valeur) then 1 else 0 end occurence from test_reponse as t_r left join reponse as r on t_r.id_reponse = r.id;

create  view v_test_point as select v_c.id_test, v_c.id_question, q.coeff, case when (sum(v_c.occurence)  = count(v_c.occurence))  then 1 else 0 end point from v_reponse_candidat as v_c join question as q on v_c.id_question = q.id group by v_c.id_test, v_c.id_question, q.coeff; 

CREATE VIEW v_test_note
 AS
 SELECT v_t.id_test,
    t.id_candidature AS id_candidat,
    sum(v_t.coeff * v_t.point) AS note,
	sum(v_t.coeff) AS total
   FROM v_test_point v_t
     JOIN test t ON v_t.id_test = t.id
  GROUP BY v_t.id_test, t.id_candidature;

CREATE  VIEW v_test_note_job
 AS
 SELECT t_n.id_test,
    t_n.id_candidat,
    t_n.note,
    t_n.total,
    c.id_job
   FROM v_test_note t_n
     JOIN candidature c ON t_n.id_candidat = c.id;

-- CONGE
create view v_cumul_conge as select id_utilisateur, case when (ceil( date_part( 'day', now() - max(date_debut)::date)/30)*2.5) > 90 then 90 else ceil( date_part( 'day', now() - max(date_debut)::date)/30)*2.5 end cumul from contrat where status=3 group by id_utilisateur;

create view v_etat_conge as select e.id as id_employe, vc.cumul, case when jour is null then 0 else jour end consomme from v_cumul_conge vc join employe e on vc.id_utilisateur = e.id_utilisateur left join conge_consomme cc on cc.id_employe = id_employe;

