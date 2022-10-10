using ApiConnector;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace client
{
    public partial class main : Form
    {
        private readonly List<Document> documents = new List<Document>();
        private readonly Dictionary<string, Document> processedDocuments = new Dictionary<string, Document>();
        private readonly Connector connector;

        public main()
        {
            InitializeComponent();
            connector = new Connector(txtEndpoint.Text);
        }

        private void btnGenerate_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < 10; i++)
            {
                documents.Add(new Document()
                {
                    filename = $"documento_{i}",
                    content = Convert.ToBase64String(Encoding.ASCII.GetBytes($"documento_{i}")),
                    priority = 1
                });
            }

            txtRequests.Text = JsonConvert.SerializeObject(documents, Formatting.Indented);
            listSentDocuments.Items.Clear();
            btnSend.Enabled = true;
        }

        private void btnSend_Click(object sender, EventArgs e)
        {
            foreach (var document in documents)
            {
                var json = JsonConvert.SerializeObject(document);
                var processId = connector.SendDocument(json);
                listSentDocuments.Items.Add(processId);
                processedDocuments.Add(processId, document);
            }

            documents.Clear();
            btnSend.Enabled = false;
            btnGetStatus.Enabled = true;
        }

        private void btnGetStatus_Click(object sender, EventArgs e)
        {
            listDocumentStatusOK.Items.Clear();
            listDocumentStatusNotOK.Items.Clear();
            foreach (var item in listSentDocuments.Items)
            {
                var response = connector.GetDocumentStatus(item.ToString());

                if (response.result == "OK")
                {
                    listDocumentStatusOK.Items.Add(response.id);
                    processedDocuments.Remove(response.id);
                }
                else
                {
                    listDocumentStatusNotOK.Items.Add(response.id);
                }
            }

            btnGetStatus.Enabled = false;
            btnReprocess.Enabled = listDocumentStatusNotOK.Items.Count > 0;
        }

        private void btnReprocess_Click(object sender, EventArgs e)
        {
            listSentDocuments.Items.Clear();
            foreach (var item in listDocumentStatusNotOK.Items)
            {
                var document = JsonConvert.SerializeObject(processedDocuments[item.ToString()]);
                var processId = connector.SendDocument(document);
                listSentDocuments.Items.Add(processId);

                processedDocuments.Add(processId, processedDocuments[item.ToString()]);
            }

            btnReprocess.Enabled = false;
            btnGetStatus.Enabled = true;
            listDocumentStatusOK.Items.Clear();
            listDocumentStatusNotOK.Items.Clear();
        }
    }
}
