#!/bin/bash
clear
echo "This tool will generate a KeyStore with a selfsigned Cert using keytool."
echo "Please ensure you have keytool installed, and your JAVA_HOME is set correctly and keytool is available on PATH"

#vars
CERTS_DIRECTORY=../../sites/myamazingapp/certs
OUTPUT_FILE=amazingSiteProdkeystore-prod.p12

echo "Deleting previus files if exists.."
rm $CERTS_DIRECTORY/$OUTPUT_FILE

#Generate dir if not exists
echo "Generating output Path $CERTS_DIRECTORY if not exist "
mkdir -p $CERTS_DIRECTORY

#verbose execution
keytool -genkeypair -v -keystore $CERTS_DIRECTORY/$OUTPUT_FILE -storepass s3cr3t -storetype PKCS12 -alias myAmazingCompanyCert -dname 'CN=myamazingapp.com, OU=My Amazing Department, O=My Amazing Company, L=Amazing City (Vallekas), ST=Amazing Country (Vallekas Independent State), C=VK' -validity 365 -keyalg RSA

echo "Finished a selfSigned Cert creation"
echo "Using selfsigned certs, Dont forget to add 'myamazingapp.com x.x.x.x' to your /etc/hosts, to avoid site Common Name Mismatch Error (ssl_error_bad_cert_domain).  https://www.digicert.com/ssl-support/certificate-name-mismatch-error.htm"