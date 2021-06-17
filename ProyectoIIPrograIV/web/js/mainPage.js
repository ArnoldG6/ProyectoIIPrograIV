function showMovies() {
    const json_img_links = {
        "movie": [
            {
                "id": "01",
                "source": "https://i.ytimg.com/vi/CLrN5enKKaE/sddefault.jpg",
            },
            {
                "id": "02",
                "source": "https://yt3.ggpht.com/ytc/AAUvwngXeznC9rHqZxOBCDVDjs5r1lskB8psMz2Nvm4I=s900-c-k-c0x00ffffff-no-rj",
            },
            {
                "id": "03",
                "source": "https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.freemovieposters.net%2Fposters%2Fsuperbad_2007_841_poster.jpg&f=1&nofb=1",
            },
            {
                "id": "04",
                "source": "https://es.web.img2.acsta.net/medias/nmedia/18/67/94/14/20242562.jpg",
            },
            {
                "id": "05",
                "source": "https://www.ecartelera.com/carteles/2500/2515/001_m.jpg",
            },
            {
                "id": "06",
                "source": "https://images-na.ssl-images-amazon.com/images/I/51ETxrFrDqL._AC_SY450_.jpg",
            },
            {
                "id": "07",
                "source": "https://images-na.ssl-images-amazon.com/images/I/51FNB6V2REL._SY445_.jpg",
            },
            {
                "id": "08",
                "source": "https://images-na.ssl-images-amazon.com/images/I/71oxR7pnRxL._SL1500_.jpg",
            },
            {
                "id": "09",
                "source": "https://parecidas.com/img_es/movie/thumb/5b/15009.jpg",
            },
            {
                "id": "10",
                "source": "https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/1200/public/media/image/2016/11/matrix.jpg?itok=YxhB9aZr",
            },
        ]
    };
    var movies_img_list = document.getElementById("movies_img_list"); //ul
    var img_links_str = JSON.parse(JSON.stringify(json_img_links));
    var img_links = img_links_str["movie"];
    //console.log(img_links);
    for (var m in img_links) {
        var source = img_links[m].source; //link de la imagen
        
        var imgCard = document.createElement("div");
        imgCard.id = img_links[m].id;
        imgCard.class = "card p-3 bg-dark col w-15 test";      
        
        var imgAn = document.createElement("a");
        imgAn.href = "#";
        imgAn.classname = "p-3 bg-dark text-center";
        imgAn.innerHTML = '<img src= '+ source + ' width="250" height="300">';
        
        imgCard.appendChild(imgAn);
        movies_img_list.appendChild(imgCard);
    }
}


showMovies(); 