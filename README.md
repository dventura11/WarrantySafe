# WarrantySafe
==================
It is an application to safe your warranties.

Install db
=================
  $sudo apt-get install mongodb mongodb-server -y
  $sudo mongod
  $mongo

  > use WarrantySafe

  > db.user.createIndex( { "userName": 1 }, { unique: true } )
  
  > db.user.createIndex( { "email": 1 }, { unique: true } )
  
  > db.user.createIndex( { firstName: 1, lastName: 1 }, { unique: true } )

  

Instalation
==================

  $git clone https://github.com/dventura11/WarrantySafe
  
  $cd WarrantySafe
  
  $gradle run
