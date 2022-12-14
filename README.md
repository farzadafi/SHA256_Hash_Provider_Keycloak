<h2>Building</h2>
<p>Enter <code> mvn clean install</code></p>
<p>JAR file is generated in ./target/SHA256_Hash_Provider_Keycloak-1.0-SNAPSHOT.jar</p>

<h2>Use In Keycloak</h2>
<p>Copy Jar file into <b>providers</b> directory in keycloak directory</p>
<img src="image/providersTreeImage.png" alt="providers directory show in tree map">
<p>And then go to the bin directory and enter <code>./kc.sh build</code> command</p>
<p dir="rtl">when build is complete you have to see this line:</p>
<img src="image/successfulBuildWithHashProvider.png" alt="successful build with hash provider">

<p>Run keycloak server with this command for just Http:</p>
<code>
./kc.sh start-dev --db-url-host 127.0.0.1 --db postgres --db-url-database keycloak --db-username postgres --db-password postgres 
--features=preview --features=declarative-user-profile --http-port=8080
</code>
<p>Or you want to use from Https:</p>
<code>
./kc.sh start-dev --https-certificate-file /keycloak-19.0.1/tls/localhost.pem --https-certificate-key-file /keycloak-19.0.1/tls/localhost-key.pem
--https-protocols TLSv1.3,TLSv1.2 --db-url-host 127.0.0.1 --db postgres --db-url-database keycloak --db-username postgres --db-password postgres
--features=preview --features=declarative-user-profile --http-port=8080 --https-port=8081
</code>
<p>After that when you enter to [keycloak](http://0.0.0.0:8080) you have to see this console: </p>
<img src="image/keycloakFirstConsole.png" alt="keycloak first console">
<p>if you register an admin before you can click on <b>Administration Console </b>and login to admin console
 but you have to enter a new username and password for create a new admin, and then you can to login 
</p>

<p>After login you enter to this console:</p>
<img src="image/FirstConsoleAfterLogin.png" alt="first console after login">
<p>click on <b>Authentication</b> from bottom and left console section and then <b>1-Policies 2-Add Policy 3-Hashing Algorithm</b>:</p>
<img src="image/keycloakAuthenticationSection.png" alt="keycloak Authentication section">
<p>and the last section you have to enter the name of your custom hash provider and then click on save button:</p>
<img src="image/addNewHashProvider.png" alt="add new hash provider">

<p>maybe you say from where I know name of custom hash Provider?when you import this to keycloak this name print here:</p>
<img src="image/nameOfHashProvicer.png" alt="name of hash provider">

<p>That's All ???? , if you have a question please message to me
</p>