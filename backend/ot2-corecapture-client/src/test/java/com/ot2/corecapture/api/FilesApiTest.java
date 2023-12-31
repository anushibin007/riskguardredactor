/*
 * Core Capture Services
 * OpenText Core Capture Services are a set of RESTful web service interfaces that provides capture functionality. Being developed in a purely RESTful style, Core Capture Services are easier to consume for the purposes of writing custom clients.  Core Capture Services identifies resources by Uniform Resource Identifiers (URIs). It defines specific media types to represent resources and drives application state transfers by using link relations. It uses a limited number of HTTP standard methods (GET, POST, and DELETE) to manipulate these resources over the HTTP protocol.  Core Capture Services (hereafter simply called, \"service\") supports only the JSON format for resource representation. JavaScript Object Notation (JSON) is a lightweight data interchange format based on a subset of the JavaScript Programming Language standard.
 *
 * The version of the OpenAPI document: 23.3
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.ot2.corecapture.api;

import com.ot2.corecapture.invoker.ApiException;
import com.ot2.corecapture.model.Get415Response;
import com.ot2.corecapture.model.InlineFileRequestBody;
import com.ot2.corecapture.model.ReturnStatusBody;
import com.ot2.corecapture.model.SessionFilesPost201Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for FilesApi
 */
@Disabled
public class FilesApiTest {

    private final FilesApi api = new FilesApi();

    /**
     * Deletes all stage files.
     *
     * This call deletes all stage files in the session including those returned by service calls. Once called, the deleted files will no longer be available.  Deleting files accepts a query string parameter, filter, as shown below. Currently, the only value this parameter supports is *, which means all files. This is the only filter value currently supported by the Services and provides for the deletion of all the files in the session.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void sessionFilesDeleteTest() throws ApiException {
        String filter = null;
        String suppressResponseCodes = null;
        ReturnStatusBody response = api.sessionFilesDelete(filter, suppressResponseCodes);
        // TODO: test validations
    }

    /**
     * Deletes a stage file.
     *
     * An individual file can be deleted. Once deleted, the file can no longer be accessed.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void sessionFilesFileIdDeleteTest() throws ApiException {
        String fileId = null;
        String suppressResponseCodes = null;
        ReturnStatusBody response = api.sessionFilesFileIdDelete(fileId, suppressResponseCodes);
        // TODO: test validations
    }

    /**
     * Retrieves the file identified by the fileId.
     *
     * Retrieving an actual file that was previously POSTed is simply performed by executing a GET on the files URI with the fileId as shown below. This will return the actual file data.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void sessionFilesFileIdGetTest() throws ApiException {
        String fileId = null;
        String suppressResponseCodes = null;
        api.sessionFilesFileIdGet(fileId, suppressResponseCodes);
        // TODO: test validations
    }

    /**
     * Appends or retries a stage file chunk.
     *
     * Chunking a file in pieces to the server requires that the POST be made to the URI represented by the src property or the URI provided by the Location header returned from the first chunk. Additional chunks append to the file and you can always retry/re-post the last chunk. Chunking requires the data for the file to be sent in base64 or binary encoding. The chunks need to be posted without gaps in order to be successful.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void sessionFilesFileIdPostTest() throws ApiException {
        String fileId = null;
        String suppressResponseCodes = null;
        String contentType = null;
        String contentRange = null;
        InlineFileRequestBody inlineFileRequestBody = null;
        SessionFilesPost201Response response = api.sessionFilesFileIdPost(fileId, suppressResponseCodes, contentType, contentRange, inlineFileRequestBody);
        // TODO: test validations
    }

    /**
     * Creates a stage file.
     *
     * You can only create one stage file at a time. Upon the first POST a unique fileId will be created by the server. File data can be posted either in base64 encoding as a JSON post or as a binary to the server.  If you need to chunk this in pieces to the server, then subsequent requests must be made to the URI represented by the src property or the URI provided by the Location header returned from the first chunk. Additional chunks append to the file and you can always retry/re-post the last chunk. The chunks need to be posted without gaps in order to be successful.  There are two ways to create a stage file:  - Create the stage file using a JSON post with base64 encoding.  - Post the file as binary using the appropriate Content-Type.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void sessionFilesPostTest() throws ApiException {
        String suppressResponseCodes = null;
        InlineFileRequestBody inlineFileRequestBody = null;
        SessionFilesPost201Response response = api.sessionFilesPost(suppressResponseCodes, inlineFileRequestBody);
        // TODO: test validations
    }

}
