<h2>Building</h2>
<p>Enter <code> mvn clean install</code></p>
<p>JAR file is generated in ./target/SHA256_Hash_Provider_Keycloak-1.0-SNAPSHOT.jar</p>

<h2>Use In Keycloak</h2>
<p>Copy Jar file into <b>providers</b> directory in keycloak directory</p>
<img src="image/providersTreeImage.png" alt="providers directory show in tree map">
<p>And then go to the bin directory and enter <code>./kc.sh build</code> command</p>
<p dir="rtl">when build is complete you have to see this line:</p>
<img src="image/successfulBuildWithHashProvider.png" alt="successful build with hash provider">