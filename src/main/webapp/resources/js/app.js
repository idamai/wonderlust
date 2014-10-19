var main = function(){
    
    
    $('.post-button').click(function(){
        
        var post = $('.status-box').val();
        
        $('<li>').prependTo('.posts');

        $('<p class="post-content">').text(post).prependTo('.posts li:first')

        $('<p class="poster-name">').text('Hee Won').prependTo('.posts li:first');
        
        $('.status-box').val('');
        
        $('.counter').text('140');
        
        $('.post-button').addClass('disabled');
        
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
    

    $('.playback').hide();

    

    ZiggeoApi.Events.on("submitted", function (data) {

        alert("Submitted a new video with token '" + data.video.token + "'!");


        var video_code = data.video.token;

        $('.playback').attr("ziggeo-video", $('video_code')); 

        $('.record').hide();

        $('.playback').show();
    });

    /*ZiggeoApi.Styles.play_button_vertical_align = "center"; // "top" or "bottom"
    ZiggeoApi.Styles.play_button_horizontal_align = "center"; // "left" or "right"
*/};

$(document).ready(main);