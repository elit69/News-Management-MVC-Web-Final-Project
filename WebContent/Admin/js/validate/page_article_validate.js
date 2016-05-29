/*
    Form category adding validator
*/
/*$(document).ready(function() {*/
        jQuery('#form_article_add').bootstrapValidator({
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
            },
            fields: {
                 
            	newstitle: {
                    validators: {
                        notEmpty: {
                           message: 'News title is required'
                        },
            			stringLength: {
            				max: 100,
            				message: 'The news title must be less than 50 characters'
            			}
                    }
                },
                newscategory: {
                    validators: {
                        notEmpty: {
                           message: 'News category  is required'
                        }
                    }
                }
                
            }
            
            
        });
     