if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(showPosition);
  } else {
    document.getElementById("demo").innerHTML =
    "Geolocation is not supported by this browser.";
  }
  
  function showPosition(position) {
    document.getElementById("parrafo").innerHTML =
    "Latitude: " + position.coords.latitude +
    "Longitude: " + position.coords.longitude;
  }