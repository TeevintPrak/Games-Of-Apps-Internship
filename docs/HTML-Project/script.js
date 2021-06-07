const overlay = document.querySelector('.overlay');
const images = document.querySelectorAll('.image img');
const popImg = document.querySelector('.popup-content img');
const caption = document.querySelector('.caption');
const closeBTN = document.querySelector('.close-button');

images.forEach(images => {
    images.addEventListener('click', () => {
        overlay.classList.add("open");
        const imgSrc = images.getAttribute('src');
        popImg.src = imgSrc;
        const altText = images.title;
        caption.textContent = altText;
    })
})

overlay.addEventListener('click', (e)=> {
    if(e.target.classList.contains('overlay')){
        overlay.classList.remove('open');
    }
})

closeBTN.addEventListener('click', (e)=> {
    overlay.classList.remove('open');
})

