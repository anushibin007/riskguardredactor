rem npm install @openapitools/openapi-generator-cli -g

rem call openapi-generator-cli generate --input-spec ./ot2-apispecs/riskguard.json --generator-name java --package-name com.ot2.riskguard --invoker-package com.ot2.riskguard.invoker --api-package com.ot2.riskguard.api --model-package com.ot2.riskguard.model --group-id com.ot2.riskguard --artifact-id ot2-riskguard-client --output ./ot2-riskguard-client

rem call openapi-generator-cli generate --input-spec ./ot2-apispecs/corecapture.json --generator-name java --package-name com.ot2.corecapture --invoker-package com.ot2.corecapture.invoker --api-package com.ot2.corecapture.api --model-package com.ot2.corecapture.model --group-id com.ot2.corecapture --artifact-id ot2-corecapture-client --output ./ot2-corecapture-client

rem call openapi-generator-cli generate --input-spec ./ot2-apispecs/contentstorageservice.json --generator-name java --package-name com.ot2.contentstorageservice --invoker-package com.ot2.contentstorageservice.invoker --api-package com.ot2.contentstorageservice.api --model-package com.ot2.contentstorageservice.model --group-id com.ot2.riskguard --artifact-id ot2-contentstorageservice-client --output ./ot2-contentstorageservice-client --global-property skipFormModel=false

cd ot2-riskguard-client
call mvn clean install
cd ..

cd ot2-corecapture-client
call mvn clean install
cd ..

cd ot2-contentstorageservice-client
call mvn clean install
cd ..

pause