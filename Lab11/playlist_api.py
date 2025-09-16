from flask import Flask, request
from flask_restful import Resource, Api
from flasgger import Swagger

app = Flask(__name__)
api = Api(app)
swagger = Swagger(app)

playlist_data = [
    {"playlist_id": 1, "playlist_name": "datenight", "movielist": ["The Notebook", "50 First Dates", "A Walk to Remember"]},
    {"playlist_id": 2, "playlist_name": "action", "movielist": ["Die Hard", "Mad Max: Fury Road", "John Wick"]},
    {"playlist_id": 3, "playlist_name": "comedy", "movielist": ["Superbad", "Step Brothers", "The Hangover"]},
]

class Playlists(Resource):
    def get(self):
        """
        Get a list of all playlists with their movies
        ---
        responses:
          200:
            description: A list of playlists with their movies
        """
        return playlist_data, 200

    def post(self):
        """
        Create a new playlist
        ---
        parameters:
          - in: body
            name: Playlist
            required: true
            schema:
                id: Playlist
                required:
                    - playlist_name
                properties:
                    playlist_name:
                        type: string
                        description: The name of the playlist
                    movielist:
                        type: array
                        items:
                            type: string
                        description: A list of movies in the playlist
        responses:
            201:
                description: A new playlist created
            400:
                description: Bad request
        """
        data = request.get_json()

        if not data or 'playlist_name' not in data:
            return {"message": "playlist_name is required"}, 400

        new_id = playlist_data[-1]['playlist_id'] + 1 if playlist_data else 1
        movielist = data.get('movielist', [])  # ถ้าไม่ส่งมาก็เป็น list ว่าง

        new_playlist = {
            'playlist_id': new_id,
            'playlist_name': data['playlist_name'],
            'movielist': movielist
        }
        playlist_data.append(new_playlist)
        return new_playlist, 201


# Routes
api.add_resource(Playlists, '/playlists')

# Run the app
if __name__ == '__main__':
    app.run(debug=True)
