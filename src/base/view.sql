create view v_info_job as  select j.id, j.title, j.jour, s.nom_service as service from job j join service s on j.idservice=s.id;