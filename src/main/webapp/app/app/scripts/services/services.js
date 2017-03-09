(function(){
'use strict';
/**
 * @author Pedro Manuel Hernandez
 * @since 2017-01-31 
 */
angular.module('FamsaPendings')
.factory('Type', function ($resource) {
    return $resource('service/type/:id',{id:'@id'},  {
        update: {method:'PUT'},
        drop: {method: 'DELETE'}
      });
})
.factory('Pending', function ($resource) {
    return $resource('service/pending/:id',{id:'@id'},  {
        update: {method:'PUT'},
        drop: {method: 'DELETE'}
      });
})
.factory('UploadFile', function ($resource) {
    return $resource('http://localhost:8080/alfresco/service/api/upload?alf_ticket=TICKET_4f1b4dd7bdc76f254b2f534c1e00272d5193c493',{},{
        save: { method:'PUT',
	           	transformRequest: formDataObject,
	            headers: {'Content-Type':undefined, enctype:'multipart/form-data'}
	    }
      });
});


function formDataObject (data) {
    var fd = new FormData();
    angular.forEach(data, function(value, key) {
        fd.append(key, value);
    });
    return fd;
}

})();