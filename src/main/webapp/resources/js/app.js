var main = function(){
    
	$('.playback').hide();
    
    $('.post-button').click(function(){
        
        var post = $('.status-box').val();
        
        $('<li>').prependTo('.posts');

        $('<p class="post-content">').text(post).prependTo('.posts li:first')

        $('<p class="poster-name">').text('Hee Won').prependTo('.posts li:first');
        
        $('.status-box').val('');
        
        $('.counter').text('140');
        
        $('.post-button').addClass('disabled');
        
    });
    
    ZiggeoApi.Events.on("submitted",function(data){
    	$('.record').hide();
    	$('.playback').show();
    });
    
     
    $('.status-box').keyup(function(){
        var postLength = $(this).val().length
        var charactersLeft = 140 - postLength
        
        $('.counter').text(charactersLeft)
        
        if (charactersLeft < 0)  {
            $('.post-button').addClass('disabled');
        }
        
        else if (charactersLeft === 140) {
            $('.post-button').addClass('disabled');
        }        

        else $('.post-button').removeClass('disabled');
        

        
    });
    
    $('.post-button').addClass('disabled');
    

    $('.video-recorder-outer').css("height", "256px");

    $('.inner-container .btn-primary').html()
};

$(document).ready(main);