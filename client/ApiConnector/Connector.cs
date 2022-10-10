using Newtonsoft.Json;
using RestSharp;

namespace ApiConnector
{
    public class Connector
    {
        private readonly RestClient client;

        public Connector(string url)
        {
            client = new RestClient(url);
        }

        public string SendDocument(string document)
        {
            var request = new RestRequest("print", Method.Post).AddJsonBody(document);
            var response = client.Execute<QueueResponse>(request);

            return JsonConvert.DeserializeObject<QueueResponse>(response.Content).id;
        }

        public QueueResponse GetDocumentStatus(string id)
        {
            var request = new RestRequest("getStatus", Method.Get).AddQueryParameter("id", id);
            var response = client.Execute<QueueResponse>(request);

            return JsonConvert.DeserializeObject<QueueResponse>(response.Content);
        }
    }
}
