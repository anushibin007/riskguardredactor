```
npm install @openapitools/openapi-generator-cli -g
openapi-generator-cli generate --input-spec ./ot2-apispecs/riskguard.json --generator-name java --package-name com.ot2.riskguard --api-package com.ot2.riskguard --model-package com.ot2.riskguard --group-id com.ot2 --artifact-id riskguard --output ./ot2-riskguard-client
```

```
cd ot2-riskguard-client
mvn clean install
cd ..
mvn clean package
mvn spring-boot:run
```