const overlay = document.querySelector('.overlay');
const popImg = document.querySelector('.popup-content img');
const caption = document.querySelector('.caption');
const closeBTN = document.querySelector('.close-button');
const popUpsImages = document.querySelectorAll('.image img');

const currentLocation = location.href;
const popUps = document.querySelectorAll('.image');

//this opens overlay and chooses images based on url
for(let i = 0; i < popUps.length; i++){
    if(popUps[i].href == currentLocation){
        overlay.classList.add("open");
        const imgSrc = popUpsImages[i].getAttribute('src');
        popImg.src = imgSrc;
        const altText = popUpsImages[i].title;
        caption.textContent = altText;
    }
}

//closes overlay when clicked on translucent area
overlay.addEventListener('click', (e)=> {
    if(e.target.classList.contains('overlay')){
        overlay.classList.remove('open');
    }
})

//closes overlay when clostBTN is clicked
closeBTN.addEventListener('click', (e)=> {
    overlay.classList.remove('open');
})

