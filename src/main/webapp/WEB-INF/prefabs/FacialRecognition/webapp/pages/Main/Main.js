/*
 * Use App.getDependency for Dependency Injection
 * eg: var DialogService = App.getDependency('DialogService');
 */

/*
 * This function will be invoked when any of this prefab's property is changed
 * @key: property name
 * @newVal: new value of the property
 * @oldVal: old value of the property
 */

Prefab.delayedCallback = function() {
    let video = document.getElementById("video");
    var tracks = video && video.srcObject && video.srcObject.getTracks && video.srcObject.getTracks();
    if (video && tracks) {
        tracks && tracks.forEach(function(track) {
            track.stop();
        });
        video.srcObject = null;
        Prefab.Widgets.dialogVideo.close();
        Prefab.Widgets.button1.iconclass = "wm-sl-l sl-close";
        Prefab.Widgets.button1.class = "btn-danger";
        Prefab.Widgets.button1.caption = "Retry";
        Prefab.Actions.errorToaster.invoke();
    }
}

Prefab.dialogVideoOpened = function($event, widget) {
    debugger
    const video = document.getElementById("video");
    startWebcam();
    // console.log(video);
    // const delayInMilliseconds = 10 * 1000;
    // setTimeout(Prefab.delayedCallback, delayInMilliseconds);
    // navigator.mediaDevices.getUserMedia({
    //         video: true
    //     })
    //     .then((stream) => {
    //         let video = document.getElementById('video');
    //         video.srcObject = stream;
    //         console.log(stream);
    //     })
    //     .catch((err) => {
    //         console.error("Error accessing the webcam: ", err);
    //     });


    // Promise.all([
    //     // pre-trained machine learning models for face detection.
    //     faceapi.nets.ssdMobilenetv1.loadFromUri("resources/faceRecogination/models"),
    //     faceapi.nets.faceRecognitionNet.loadFromUri("resources/faceRecogination/models"),
    //     faceapi.nets.faceLandmark68Net.loadFromUri("resources/faceRecogination/models"),
    // ]).then(startWebcam);

    function startWebcam() {
        // Access to the user's webcam
        navigator.mediaDevices.getUserMedia({
                video: true,
                audio: false,
            })
            .then((stream) => {
                video.srcObject = stream;
            })
            .catch((error) => {
                console.error(error);
            });
    }

    // function getLabeledFaceDescriptions() {
    //     const labels = ["raj"];
    //     return Promise.all(
    //         labels.map(async(label) => {
    //             const descriptions = [];
    //             for (let i = 1; i <= 2; i++) {
    //                 const img = await faceapi.fetchImage(`resources/faceRecogination/labels/${label}/${i}.jpg`);
    //                 const detections = await faceapi
    //                     .detectSingleFace(img)
    //                     .withFaceLandmarks()
    //                     .withFaceDescriptor();
    //                 descriptions.push(detections.descriptor);
    //             }
    //             return new faceapi.LabeledFaceDescriptors(label, descriptions);
    //         })
    //     );
    // }

    // video.addEventListener("play", async() => {
    //     const labeledFaceDescriptors = await getLabeledFaceDescriptions();
    //     const faceMatcher = new faceapi.FaceMatcher(labeledFaceDescriptors);
    //     const canvas = faceapi.createCanvasFromMedia(video);
    //     //document.body.append(canvas);

    //     const displaySize = {
    //         width: video.width,
    //         height: video.height
    //     };

    //     faceapi.matchDimensions(canvas, displaySize);

    //     setInterval(async() => {
    //         const detections = await faceapi
    //             .detectAllFaces(video)
    //             .withFaceLandmarks()
    //             .withFaceDescriptors();

    //         const resizedDetections = faceapi.resizeResults(detections, displaySize);

    //         //canvas.getContext("2d").clearRect(0, 0, canvas.width, canvas.height);

    //         const results = resizedDetections.map((d) => {
    //             return faceMatcher.findBestMatch(d.descriptor);
    //         });

    //         results.forEach((result, i) => {
    //             Prefab.closeTriggred = false;
    //             // const box = resizedDetections[i].detection.box;
    //             // const drawBox = new faceapi.draw.DrawBox(box, {
    //             //     label: result,
    //             // });
    //             // drawBox.draw(canvas);
    //             if (result.label !== "unknown" && !Prefab.closeTriggred) { // success case
    //                 setTimeout(function() {
    //                     var tracks = video.srcObject && video.srcObject.getTracks && video.srcObject.getTracks();
    //                     tracks && tracks.forEach(function(track) {
    //                         track.stop();
    //                     });
    //                     video.srcObject = null;
    //                     Prefab.Widgets.button1.iconclass = "wm-sl-l sl-check";
    //                     Prefab.Widgets.button1.class = "btn-success";
    //                     Prefab.Widgets.button1.caption = "Success";
    //                     Prefab.Widgets.dialogVideo.close();
    //                     Prefab.Actions.successtoaster.invoke();
    //                     Prefab.closeTriggred = true
    //                 }, 700);
    //             }
    //             // else {
    //             //     document.querySelector("canvas").style.display = "inline-block";
    //             //     Prefab.Widgets.button1.iconclass = "";
    //             // }
    //         });
    //     }, 100);
    // });
};

Prefab.Capture_ImageClick = function($event, widget) {
    debugger
    const video = document.getElementById('video');
    const canvas = document.getElementById('canvas');
    const context = canvas.getContext('2d');

    // Set canvas size to match video
    canvas.width = 450;
    canvas.height = 338;
    console.log(canvas.width, canvas.height)

    // Draw video frame onto canvas
    context.drawImage(video, 0, 0, canvas.width, canvas.height);
    // Prefab.Widgets.html1.show = false;

    // Convert canvas content to a data URL representing the image
    const imageUrl = canvas.toDataURL('image/png');
    console.log('Captured Image URL:', imageUrl);
    // Prefab.Widgets.picture2.imgSource = imageUrl;
    Prefab.url = imageUrl;
    Prefab.Widgets.dialogVideo.close();
    var tracks = video && video.srcObject && video.srcObject.getTracks && video.srcObject.getTracks();
    if (video && tracks) {
        tracks && tracks.forEach(function(track) {
            track.stop();
        });
        video.srcObject = null;

    }


}
