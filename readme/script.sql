-- sqlexpress
conn system/coti;

select user from dual;

select * from cat;

insert into tabelausuario (id, numero, nome, data_cadastro)
  values (tabelasequencia.nextval, '1234', 'lu',
    to_date('10/10/2015 20:22', 'dd/MM/yyyy hh24:mi'));

commit;

column nome format a20;
column data_cadastro format a28;
column numero format a15;
set linesize 2000;

select * from tabelausuario;

alter session set nls_date_format='dd/mm/yyyy hh24:mi:ss';
alter session set nls_timestamp_format='dd/mm/yyyy hh24:mi:ss';

select * from tabelausuario;
